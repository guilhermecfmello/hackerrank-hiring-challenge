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

// Complete the countTriplets function below.
fun countTriplets(arr: Array<Long>, r: Long): Long {
    var tripletsCount: Long = 0
    arr.forEachIndexed { i, element ->
        arr.drop(i+1).forEachIndexed { j, subElement ->
            if(isGeometricProgression(element, subElement, r)) {
                arr.drop(j+1).forEachIndexed { k, lastElement ->
                    if(isGeometricProgression(subElement, lastElement, r)) {
                        tripletsCount++
                    }
                }
            }
        }
    }
    return tripletsCount
}

fun isGeometricProgression(a: Long, b: Long, r: Long): Boolean {
    return b == a*r
}

fun main(args: Array<String>) {
    val nr = readLine()!!.trimEnd().split(" ")

    val n = nr[0].toInt()

    val r = nr[1].toLong()

    val arr = readLine()!!.trimEnd().split(" ").map{ it.toLong() }.toTypedArray()

    val ans = countTriplets(arr, r)

    println(ans)
}
