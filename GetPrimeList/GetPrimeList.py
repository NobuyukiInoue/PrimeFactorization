import math
import os
import sys


def main():
    argv = sys.argv
    argc = len(argv)

    if argc < 2:
        exit_msg(argv[0])

    n = int(argv[1])
    primes = sieve_of_eratosthenes(n)
    print(primes)


def exit_msg(argv0):
    print("Usage: python %s [max_number]".format(argv0))
    exit(0)
 

def sieve_of_eratosthenes(primeNumber_Max):
    """エラトステネスのふるいを利用して素数の配列を生成する"""

    dest = int(math.sqrt(primeNumber_Max))
    target_list = list(range(2, primeNumber_Max + 1))
    prime_list = []
 
    while True:
        num_min = min(target_list)
        if num_min >= dest:
            prime_list.extend(target_list)
            break
        prime_list.append(num_min)
 
        i = 0
        while True:
            if i >= len(target_list):
                break
            elif target_list[i] % num_min == 0:
                target_list.pop(i)
            i += 1

    return prime_list


if __name__ == "__main__":
    main()
