// Complete the freqQuery function below.
fun freqQuery(queries: Array<Array<Int>>): Array<Int> {
    val result = arrayListOf<Int>()
    val hashMap = mutableMapOf<Int, Int>()
    var newValue: Int
    queries.forEach { query ->
        var op = query[0]
        var value = query[1]
        when(op) {
            1 -> {
                newValue = hashMap.getOrDefault(value, 0) + 1
                hashMap.put(value, newValue)
            }
            2 -> {
                newValue = hashMap.get(value) ?: -1
                if(newValue != -1) {
                    hashMap.put(value, newValue - 1)
                    if(newValue - 1 == 0)
                        hashMap.remove(value)
                }
            }
            else -> {
                result += 1.takeIf{ hashMap.containsValue(value) } ?: 0
            }
        }
    }
    return result.toTypedArray()
}

fun main(args: Array<String>) {
    val q = readLine()!!.trim().toInt()

    val queries = Array<Array<Int>>(q, { Array<Int>(2, { 0 }) })

    for (i in 0 until q) {
        queries[i] = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()
    }

    val ans = freqQuery(queries)

    println(ans.joinToString("\n"))
}

