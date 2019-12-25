#include <stdio.h>
#include <stdlib.h>

#include "include/functions.h"

int main(int argc, char* argv[])
{
    if (argc < 2) {
        printf("Usage %s <target number>\n", argv[0]);
        return -1;
    }

    // Read the value you want to factor
    long long int n = strtoll(argv[1], NULL, 10);

    primefactorization(n);
}
