package main

import (
	"fmt"
	"math/big"
	"os"
	"path/filepath"

	primefactorization "./PrimeFactorization_bigint"
)

func main() {
	if len(os.Args) < 2 {
		printMsgAndExit(os.Args[0])
	}

	n, result := new(big.Int).SetString(os.Args[1], 10)
	if n == nil || result == false {
		fmt.Printf("%s ... big.SetString() error.\n", os.Args[1])
		os.Exit(1)
	}

	primefactorization.Main(n)
}

func printMsgAndExit(arg0 string) {
	fmt.Printf("Usage: go run %s <n>", getFileNameWithoutExt(arg0)+".go")
	os.Exit(1)
}

func getFileNameWithoutExt(path string) string {
	return filepath.Base(path[:len(path)-len(filepath.Ext(path))])
}
