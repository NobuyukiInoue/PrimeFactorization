package systeminformation

import (
	"fmt"
	"runtime"
	"time"
)

// PrintSystemInformation ...
func PrintSystemInformation() {
	t := time.Now()
	const layout = "2006/01/02 15:04:05"

	fmt.Println("=====================================================================================")
	fmt.Printf("%-10s : %s\n", "Date", t.Format(layout))
	fmt.Printf("%-10s : %s\n", "Language", "Go")
	fmt.Printf("%-10s : %s\n", "OS", runtime.GOOS)
	fmt.Println("=====================================================================================")
}
