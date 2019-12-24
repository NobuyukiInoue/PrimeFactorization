package main

import (
	"fmt"
	"os"
	"path/filepath"
	"strconv"

	primefactorization "./PrimeFactorization_int64"
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

	primefactorization.Main(n)
}

func printMsgAndExit(arg0 string) {
	fmt.Printf("Usage: go run %s <n>", getFileNameWithoutExt(arg0)+".go")
	os.Exit(1)
}

func getFileNameWithoutExt(path string) string {
	return filepath.Base(path[:len(path)-len(filepath.Ext(path))])
}
