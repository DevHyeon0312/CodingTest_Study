package baekjoonSolution

fun main() {
    val (N) = readLine()!!.split(" ").map { it.toInt() }

    val list = readLine()!!.split(" ").map { it.toInt() }.toList()

    val min = list.minOrNull()
    val max = list.maxOrNull()
    println("$min $max")
}