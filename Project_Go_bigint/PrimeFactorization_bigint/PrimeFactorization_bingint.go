package PrimeFactorization_bigint

import (
	"fmt"
	"math/big"
	"strings"
	"time"

	systeminformation "./systeminformation"
)

func Main(n *big.Int) {
	if n.Cmp(big.NewInt(0)) == -1 {
		fmt.Printf("%d is not positive longeger.\n", n)
		return
	}

	systeminformation.PrintSystemInformation()

	bitCount := GetBitLength(*n, 5000)
	fmt.Printf("%s < pow(2, %d) ... %d bit\n", n.String(), bitCount, bitCount)

	timeStart := time.Now()

	primes := CalcPrimes(n)

	timeEnd := time.Now()

	fmt.Printf("n = %s, primes = [%s]\n", n.String(), ArrayBigIntToString(primes))
	fmt.Printf("Answer Check : %s\n", AnswerCheck(n, primes))
	fmt.Printf("Execute time : %.3f [s]\n\n", timeEnd.Sub(timeStart).Seconds())
}

// GetBitLength ...
func GetBitLength(N big.Int, max int64) int {
	var i int64
	for i = 1; i < max; i++ {
		if N.Cmp(BigPow(big.NewInt(2), big.NewInt(i))) < 0 {
			return (int)(i)
		}
	}
	return (int)(-1)
}

// BigPow ... Pow() for BigInt
func BigPow(i, e *big.Int) *big.Int {
	return new(big.Int).Exp(i, e, nil)
}

func mySqrt(x *big.Int) *big.Int {
	for left, right := big.NewInt(0), x; ; {
		// mid := left + (right-left)/2
		temp1 := new(big.Int).Sub(right, left)
		temp2 := new(big.Int).Mul(temp1, big.NewInt(2))
		mid := new(big.Int).Add(left, temp2)
		mid2 := new(big.Int).Mul(mid, mid)
		if mid2.Cmp(x) > 0 {
			right = new(big.Int).Sub(mid, big.NewInt(1))
		} else {
			mid3_1 := new(big.Int).Add(mid, big.NewInt(1))
			mid3 := new(big.Int).Mul(mid3_1, mid3_1)
			if mid3.Cmp(x) > 0 {
				return mid
			} else {
				left = new(big.Int).Add(mid, big.NewInt(1))
			}
		}
	}
}

// CalcPrimes ...
func CalcPrimes(n *big.Int) []*big.Int {
	// 素因数を格納する配列
	results := make([]*big.Int, 0)
	workN := n

	num0 := big.NewInt(0)
	num1 := big.NewInt(1)
	num2 := big.NewInt(2)
	num3 := big.NewInt(3)
	num4 := big.NewInt(4)

	//max = int(math.sqrt(n)) + 1
	max := new(big.Int).Add(new(big.Int).Sqrt(n), num1) // 7.169[s] (n = 12345678901)
	//max := new(big.Int).Add(mySqrt(n), big.NewInt(1)) // 7.241[s] (n = 12345678901)

	// 2 で割っていく
	for workNnext, mod := new(big.Int).DivMod(workN, num2, new(big.Int)); mod.Cmp(num0) == 0; workNnext, mod = new(big.Int).DivMod(workN, num2, new(big.Int)) {
		results = append(results, num2)

		if workNnext.Cmp(big.NewInt(1)) == 0 {
			return results
		}

		workN = workNnext
	}

	// 3 で割っていく
	for workNnext, mod := new(big.Int).DivMod(workN, num3, new(big.Int)); mod.Cmp(num0) == 0; workNnext, mod = new(big.Int).DivMod(workN, num3, new(big.Int)) {
		results = append(results, num3)

		if workNnext.Cmp(big.NewInt(1)) == 0 {
			return results
		}

		workN = workNnext
	}

	// 5 ～ math.sqrt(n) の数字で割っていく
	flag := true
	for num := big.NewInt(5); num.Cmp(max) != 0; {
		for workNnext, mod := new(big.Int).DivMod(workN, num, new(big.Int)); mod.Cmp(num0) == 0; workNnext, mod = new(big.Int).DivMod(workN, num, new(big.Int)) {
			results = append(results, num)

			if workNnext.Cmp(num1) == 0 {
				return results
			}
			workN = workNnext
		}

		if flag {
			num = new(big.Int).Add(num, num2)
		} else {
			num = new(big.Int).Add(num, num4)
		}
		flag = !flag
	}

	if workN.Cmp(num1) != 0 {
		results = append(results, workN)
	}

	return results
}

// ArrayBigIntToString ...
func ArrayBigIntToString(primes []*big.Int) string {
	if len(primes) <= 0 {
		return ""
	}
	primesStr := make([]string, len(primes))
	for i := 0; i < len(primes); i++ {
		primesStr[i] = (*primes[i]).String()
	}

	resultStr := strings.Join(primesStr[:], ", ")
	return resultStr
}

// AnswerCheck ...
func AnswerCheck(n *big.Int, primes []*big.Int) string {
	answer := big.NewInt(1)
	for _, target := range primes {
		answer = new(big.Int).Mul(answer, target)
	}

	if n.Cmp(answer) == 0 {
		return "OK"
	} else {
		return "NG"
	}
}
