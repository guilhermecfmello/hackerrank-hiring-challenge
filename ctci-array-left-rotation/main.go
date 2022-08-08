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
 * Complete the 'rotLeft' function below.
 *
 * The function is expected to return an INTEGER_ARRAY.
 * The function accepts following parameters:
 *  1. INTEGER_ARRAY a
 *  2. INTEGER d
 */

func rotLeft(a []int32, d int32) []int32 {
    // Write your code here
    swapIndex := int32(len(a)) - d
    if(swapIndex == d){
        symetricRotation(a, d)
    } else {
        assymetricRotation(a,d)
    }
    
    return a
}

func symetricRotation(a []int32, d int32) {
    swapIndex := int32(len(a)) - d
    pivot := int32(0)
    for j := int32(0); j < int32(len(a)) - d ; j++ {
        swap(a, pivot, swapIndex)
        pivot++
        swapIndex++
    }
}

func assymetricRotation(a []int32, d int32) {
    swapIndex := int32(len(a)) - d
    for j := 0; j < len(a) - 1 ; j++ {
        swap(a, 0, swapIndex)
        swapIndex -= d
        if swapIndex < 0 {
            swapIndex = int32(len(a)) + swapIndex
        }
    }
}

func swap(a []int32, indexA int32, indexB int32) {
    a[indexA], a[indexB] = a[indexB], a[indexA]
}

func main() {
    reader := bufio.NewReaderSize(os.Stdin, 16 * 1024 * 1024)

    stdout, err := os.Create(os.Getenv("OUTPUT_PATH"))
    checkError(err)

    defer stdout.Close()

    writer := bufio.NewWriterSize(stdout, 16 * 1024 * 1024)

    firstMultipleInput := strings.Split(strings.TrimSpace(readLine(reader)), " ")

    nTemp, err := strconv.ParseInt(firstMultipleInput[0], 10, 64)
    checkError(err)
    n := int32(nTemp)

    dTemp, err := strconv.ParseInt(firstMultipleInput[1], 10, 64)
    checkError(err)
    d := int32(dTemp)

    aTemp := strings.Split(strings.TrimSpace(readLine(reader)), " ")

    var a []int32

    for i := 0; i < int(n); i++ {
        aItemTemp, err := strconv.ParseInt(aTemp[i], 10, 64)
        checkError(err)
        aItem := int32(aItemTemp)
        a = append(a, aItem)
    }

    result := rotLeft(a, d)

    for i, resultItem := range result {
        fmt.Fprintf(writer, "%d", resultItem)

        if i != len(result) - 1 {
            fmt.Fprintf(writer, " ")
        }
    }

    fmt.Fprintf(writer, "\n")

    writer.Flush()
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
