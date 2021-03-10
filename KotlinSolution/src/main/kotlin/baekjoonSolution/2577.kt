package baekjoonSolution

fun main() {
    val (A) = readLine()!!.split(" ").map { it.toInt() }
    val (B) = readLine()!!.split(" ").map { it.toInt() }
    val (C) = readLine()!!.split(" ").map { it.toInt() }

    val calc : String = (A * B * C).toString()

    var arr : IntArray = intArrayOf(0,0,0,0,0,0,0,0,0,0)

    for (c in calc) {
        val index = c.toInt()-48
        arr[index] = arr[index] +1
    }

    for (i in arr) {
        println(i)
    }
}