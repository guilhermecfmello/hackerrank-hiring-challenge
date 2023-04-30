import java.io.*
import java.math.*
import java.security.*
import java.text.*
import java.util.*
import java.util.concurrent.*
import java.util.function.*
import java.util.regex.*
import java.util.stream.*
import kotlin.collections.*
import kotlin.comparisons.*
import kotlin.io.*
import kotlin.jvm.*
import kotlin.jvm.functions.*
import kotlin.jvm.internal.*
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*

/*
 * Complete the 'countSwaps' function below.
 *
 * The function accepts INTEGER_ARRAY a as parameter.
 */

fun countSwaps(a: Array<Int>): Unit {
    var swapCounter = 0
    for(i in 0..a.size-1) {
        for(j in 0..a.size-2) {
            if(a[j] > a[j+1]){
                swapCounter = swap(a, j, j+1, swapCounter)
            }
        }
    }
    println("Array is sorted in $swapCounter swaps.")
    println("First Element: ${a.first()}")
    println("Last Element: ${a.last()}")
    return
}

fun swap(a: Array<Int>, i: Int, j: Int, count: Int): Int {
    val tmp = a[i]
    a[i] = a[j]
    a[j] = tmp
    return count + 1
}

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    val a = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    countSwaps(a)
}
