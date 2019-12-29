package PrimeFactorization

import (
	"fmt"
	"strconv"
	"strings"
	"time"

	systeminformation "./systeminformation"
)

func Main(n int64) {
	if n < 2 {
		fmt.Printf("%d is not positive longeger.\n", n)
		return
	}

	systeminformation.PrintSystemInformation()

	bitCount := GetBitLength(n, 5000)
	fmt.Printf("%s < pow(2, %d) ... %d bit\n", strconv.FormatInt(n, 10), bitCount, bitCount)

	timeStart := time.Now()

	primes := CalcPrimes(n)

	timeEnd := time.Now()

	fmt.Printf("n = %s, primes = [%s]\n", strconv.FormatInt(n, 10), ArrayInt64ToString(primes))
	fmt.Printf("Answer Check: %s\n", AnserCheck(n, primes))
	fmt.Printf("Execute time: %.3f [s]\n\n", timeEnd.Sub(timeStart).Seconds())
}

func sqrtint64(x int64) int64 {
	if x == 0 {
		return 0
	}
	var left, right, ans int64
	left, right, ans = 1, x, 0
	for left <= right {
		mid := left + (right-left)/2
		if mid <= x/mid {
			left = mid + 1
			ans = mid
		} else {
			right = mid - 1
		}
	}
	return ans
}

func powint64(x int64, y int64) int64 {
	ans := int64(1)
	for i := int64(0); i < y; i++ {
		ans *= x
	}
	return ans
}

// GetBitLength ...
func GetBitLength(n int64, max int64) int64 {
	for i := int64(1); i < max; i++ {
		//if n <= int64(math.Pow(2, float64(i))) {
		if n <= powint64(2, i) {
			return i
		}
	}
	return -1
}

// CalcPrimes ...
func CalcPrimes(n int64) []int64 {
	// 素因数を格納する配列
	results := make([]int64, 0)

	//	max := int64(math.Sqrt(float64(n))) + 1
	max := int64(sqrtint64(n)) + 1

	// 2 で割っていく
	for n%2 == 0 {
		results = append(results, 2)
		n /= int64(2)
	}

	// 3 ～ math.sqrt(n) の数字で割っていく
	for num := int64(3); num < max; num += 2 {
		for n%num == 0 {
			results = append(results, num)
			n /= num
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

func AnserCheck(n int64, primes []int64) string {
	answer := (int64)(1)
	for _, target := range primes {
		answer *= target
	}

	if n == answer {
		return "OK"
	} else {
		return "NG"
	}
}
