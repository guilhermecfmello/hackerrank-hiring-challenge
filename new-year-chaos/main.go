package main

import (
	"bufio"
	"fmt"
	"io"
	"os"
	"strconv"
	"strings"
)

/*
 * Complete the 'minimumBribes' function below.
 *
 * The function accepts INTEGER_ARRAY q as parameter.
 */

func minimumBribes(q []int32) {
    if checkChaos(q) {
        fmt.Println("Too Chaotic")
    } else {
        fmt.Println(getMinimumBribes(q))
    }
}

func getMinimumBribes(q []int32) int32 {
    acumulatedSum, sum := int32(0), int32(0)
    i := int32(len(q) - 1)
    for i > 0 {
        if q[i] < i+1 {
            sum = searchPerson(q, i)
            i = i - sum + 1
        } else {
            sum = 1
            i--
        }
        acumulatedSum += sum
    }
    return acumulatedSum
}

func searchPerson(q []int32, i int32) int32 {
    if q[i-1] == i + 1 {
        return 1
    }
    return 2
}

func checkChaos(q []int32) bool {
    for i := 0; i < len(q) ; i++ {
        if (q[i] - int32(i)) > 3 {
            return true
        }
    }
    return false
}

func main() {
    reader := bufio.NewReaderSize(os.Stdin, 16 * 1024 * 1024)

    tTemp, err := strconv.ParseInt(strings.TrimSpace(readLine(reader)), 10, 64)
    checkError(err)
    t := int32(tTemp)

    for tItr := 0; tItr < int(t); tItr++ {
        nTemp, err := strconv.ParseInt(strings.TrimSpace(readLine(reader)), 10, 64)
        checkError(err)
        n := int32(nTemp)

        qTemp := strings.Split(strings.TrimSpace(readLine(reader)), " ")

        var q []int32

        for i := 0; i < int(n); i++ {
            qItemTemp, err := strconv.ParseInt(qTemp[i], 10, 64)
            checkError(err)
            qItem := int32(qItemTemp)
            q = append(q, qItem)
        }

        minimumBribes(q)
    }
}

func readLine(reader *bufio.Reader) string {
    str, _, err := reader.ReadLine()
    if err == io.EOF {
        return ""
    }

    return strings.TrimRight(string(str), "\r\n")
}

func checkError(err error) {
    if err != nil {
        panic(err)
    }
}
