package primelibs

import (
	"math"
	"strconv"
	"strings"
)

// GetBitLength ...
func GetBitLength(n int64, max int64) int64 {
	for i := int64(1); i < max; i++ {
		if n <= int64(math.Pow(2, float64(i))) {
			return i
		}
	}
	return -1
}

// CalcPrimes ...
func CalcPrimes(n int64) []int64 {
	// 素因数を格納する配列
	results := make([]int64, 0)

	// 2 ～ math.sqrt(n) の数字で割っていく
	max := int64(math.Sqrt(float64(n))) + 1

	for num := int64(2); num < max; num++ {
	    for n % num == 0 {
	    	n /= num
			results = append(results, num)
		}

		if n == 1 {
			break
		}
	}

	if n != 1 {
		results = append(results, n)
	}

	return results
}

// ArrayInt64ToString ...
func ArrayInt64ToString(primes []int64) string {
	if len(primes) <= 0 {
		return ""
	}
	primesStr := make([]string, len(primes))
	for i := 0; i < len(primes); i++ {
		primesStr[i] = strconv.FormatInt(primes[i], 10)
	}

	resultStr := strings.Join(primesStr[:], ", ")
	return resultStr
}
