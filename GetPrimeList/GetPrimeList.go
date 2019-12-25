package main

import (
	"fmt"
	"math"
	"os"
	"path/filepath"
	"strconv"
	"strings"
)

func main() {
	if len(os.Args) < 2 {
		printMsgAndExit(os.Args[0])
	}

	n, err := strconv.ParseInt(os.Args[1], 10, 64)
	if err != nil {
		fmt.Printf("%s ... ParseInt() error.\n", os.Args[1])
		os.Exit(1)
	}

	primes := sieveOfEratosthenes(n)
	//	fmt.Print(primes)
	fmt.Printf("[%s]\n", ArrayInt64ToString(primes))
}

func printMsgAndExit(arg0 string) {
	fmt.Printf("Usage: go run %s <target number>", getFileNameWithoutExt(arg0)+".go")
	os.Exit(1)
}

func getFileNameWithoutExt(path string) string {
	return filepath.Base(path[:len(path)-len(filepath.Ext(path))])
}

func sieveOfEratosthenes(maxvalue int64) []int64 {
	// エラトステネスのふるいを利用して素数の配列を生成する
	BLOCKSIZE := int64(0x8000)
	SqrtOfMAXVAL := int64(math.Sqrt(float64(maxvalue))) + 1
	flags := make([]byte, maxvalue+BLOCKSIZE+1)

	var i, j, count int64

	for i = 2; i <= SqrtOfMAXVAL; i++ {
		//	if !flags[i]
		if flags[i] == 0 {
			for j := 2 * i; j <= SqrtOfMAXVAL; j += i {
				flags[j] = 1
			}
		}
	}

	count = 0
	for i = 2; i <= SqrtOfMAXVAL; i++ {
		//	count += !flags[i]
		if flags[i] != 0 {
			count++
		}
	}

	index := make([]int64, count)
	step := make([]int64, count)
	for i, j := int64(2), int64(0); ; i++ {
		//	if !flags[i]
		if flags[i] == 0 {
			index[j] = 2 * i
			step[j] = i
			j++
			if j >= count {
				break
			}
		}
	}

	for i = 0; i <= maxvalue; i += BLOCKSIZE {
		for j = 0; j < count; j++ {
			for index[j] < (i + BLOCKSIZE) {
				flags[index[j]] = 1
				index[j] += step[j]
			}
		}
	}

	count = 0
	prime_list := make([]int64, 0)
	for i = 2; i <= maxvalue; i++ {
		//	count += !flags[i]
		if flags[i] == 0 {
			count++
			prime_list = append(prime_list, i)
		}
	}
	return prime_list
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
