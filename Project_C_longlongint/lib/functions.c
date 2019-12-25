#include <math.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

#include "../include/functions.h"
#include "../include/mylib.h"
#include "../include/systeminformation.h"

void primefactorization(long long int n)
{
    if (n < 2) {
        printf("%ld is not positive longeger.\n", n);
        return;
    }

    print_properties();
    printf("%lld < pow(2, %ld)\n", n,  get_bitlength(n, 4097));

    clock_t time_start = clock();

    s_primes* primes = trial_division(n);

    clock_t time_end = clock();

    printf("n = %lld, primes = [%s]\n", n, arraylonglong_To_chararray(primes));
    printf("Answer Check : %s\n", answer_check(n, primes));
    printf("Execute time : %.4f [s]\n\n", (double)(time_end - time_start)/CLOCKS_PER_SEC);
}

long long int get_bitlength(long long int n, long long int max)
{
    for (long long int i = 1; i < max; i++) {
        if (n <= powl(2, i)) {
            return i;
        }
    }
    return -1;
}

long long int sqrtll(long long int x)
{
    if (x == 0)
        return 0;
    long long int left = 1, right = x;
    long long int ans = 0;
    while (left <= right) {
        long long int mid = left + (right - left) / 2;
        if (mid <= x / mid) {
            left = mid + 1;
            ans = mid;
        } else {
            right = mid - 1;
        }
    }
    return ans;
}

s_primes *trial_division(long long int n)
{
    long long int prime_list[1000];
    long long int max = (long long int)(sqrtll(n)) + 1;
    int count = 0;
    long long int work_n = n;

    // 2 で割っていく
    while (work_n % 2 == 0) {
        prime_list[count++] = (long long int)2;
        work_n /= 2;
    }

    // 3 ～ Math.sqrt(n) で割っていく
    for (long long int i = 3; i < max; i += (long long int)2) {
        while (work_n % i == 0) {
            prime_list[count++] = (long long int)i;
            work_n /= i;
        }
    }

    if (work_n != 1) {
        prime_list[count++] = work_n;
    }

    s_primes* primes = (s_primes *)malloc(sizeof(s_primes));
    primes->list = (long long int *)malloc(sizeof(long long int)* count);
    primes->length = count;

    for (int i = 0; i < count; i++) {
        primes->list[i] = prime_list[i];
    }

    return primes;
}

char *arraylonglong_To_chararray(s_primes *primes)
{
    if (sizeof(primes) <= 0) {
        return "";
    }

    char *resultStr = (char *)malloc(sizeof(char) * resultStrMAX);
    char work_str[1000];

    sprintf(resultStr, "%ld", primes->list[0]);

    int total_length = 0;

    for (int i = 1; i < primes->length; i++) {
        sprintf(work_str, ", %lld", primes->list[i]);

        total_length += strlen(work_str);
        if (total_length < resultStrMAX) {
            strcat(resultStr, work_str);
        } else {
            err_exit("arraylong_to_chararray() ... total_length error.");
        }
    }

    return resultStr;
}

char *answer_check(long long int n, s_primes* primes) {
    long long int answer = 1;

    for (int i = 0; i < primes->length; i++)
        answer *= primes->list[i];

    if (answer == n)
        return "OK";
    else
        return "NG";
}
