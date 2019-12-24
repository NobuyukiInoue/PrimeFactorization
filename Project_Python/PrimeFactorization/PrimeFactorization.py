# -*- coding: utf-8 -*-

import math
import time
from .SystemInformation import SystemInformation

def main(n):
    if n <= 0:
        print("{0} is not positive integer.".format(n))
        exit(1)

    SystemInformation.printSystemInformation()

    for i in range(1, 512 + 1):
        if n < pow(2, i):
            break
    print("{0:d} < pow(2, {1:d}) ... {1:d} bit".format(n, i))

    time0 = time.time()

    primes = trial_division(n)
    time1 = time.time()

    print("n = {0:d}, primes = {1}".format(n, primes))
    print("Answer Check : {0}".format(mul_check(n, primes)))
    print("Execute time : {0:f}[s]".format(time1 - time0))


def exit_msg(argv0):
    print("Usage: python {0} [target number]".format(argv0))
    exit(0)


def trial_division(n):
    """Return a list of the prime factors for a natural number."""

    """素因数を格納するリスト"""
    prime_list = []

    """2 ～ math.sqrt(n) の数字で割っていく"""
    max = int(math.sqrt(n)) + 1
    while n % 2 == 0:
        prime_list.append(2)
        n //= 2

    for num in range(3, max, 2):
        while n % num == 0:
            n //= num
            prime_list.append(num)

    if n != 1:
        prime_list.append(n)

    return prime_list

def mul_check(n, primes):
    answer = 1
    for target in primes:
        answer *= target

    if n == answer:
        return "OK"
    else:
        return "NG"

if __name__ == "__main__":
    main()
