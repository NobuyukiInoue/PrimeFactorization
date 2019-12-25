struct struct_primes {
    long long int* list;
    int length;
};

typedef struct struct_primes s_primes;

void primefactorization(long long int n);
long long int get_bitlength(long long int n, long long int max);
long long int sqrtll(long long int n);
s_primes* trial_division(long long int n);
char *arraylonglong_To_chararray(s_primes* primes);
char* answer_check(long long int n, s_primes* primes);

#define resultStrMAX    65535
