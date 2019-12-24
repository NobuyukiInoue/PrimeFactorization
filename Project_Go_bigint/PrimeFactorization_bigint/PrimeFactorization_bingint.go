package PrimeFactorization_bigint

import (
	"fmt"
	"math/big"
	"time"

	primelibs "./primelibs_bigint"
	systeminformation "./systeminformation"
)

func Main(n *big.Int) {
	if n.Cmp(big.NewInt(0)) == -1 {
		fmt.Printf("%d is not positive longeger.\n", n)
		return
	}

	systeminformation.PrintSystemInformation()


	bitCount := primelibs.GetBitLength(*n, 5000)
	fmt.Printf("%s < pow(2, %d) ... %d bit\n", n.String(), bitCount, bitCount)

	timeStart := time.Now()

	resultArray := primelibs.CalcPrimes(n)

	timeEnd := time.Now()

	fmt.Printf("n = %s, primes = [%s]\n", n.String(), primelibs.ArrayBigIntToString(resultArray))
	fmt.Printf("Execute time: %.3f [s]\n\n", timeEnd.Sub(timeStart).Seconds())
}
