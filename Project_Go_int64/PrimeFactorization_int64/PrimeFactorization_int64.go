package PrimeFactorization

import (
	"fmt"
	"strconv"
	"time"

	primelibs "./primelibs_int64"
	systeminformation "./systeminformation"
)

func Main(n int64) {
	if n < 2 {
		fmt.Printf("%d is not positive longeger.\n", n)
		return
	}

	systeminformation.PrintSystemInformation()

	bitCount := primelibs.GetBitLength(n, 5000)
	fmt.Printf("%s < pow(2, %d) ... %d bit\n",  strconv.FormatInt(n, 10), bitCount, bitCount)

	timeStart := time.Now()

	resultArray := primelibs.CalcPrimes(n)

	timeEnd := time.Now()

	fmt.Printf("n = %s, primes = [%s]\n",  strconv.FormatInt(n, 10), primelibs.ArrayInt64ToString(resultArray))
	fmt.Printf("Execute time: %.3f [s]\n\n", timeEnd.Sub(timeStart).Seconds())
}
