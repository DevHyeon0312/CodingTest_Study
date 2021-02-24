package baekjoonSolution


fun main() {
    val (n) = readLine()!!.split(" ").map { it.toInt() }

    for (i in 1..n) {
        println(
            readLine()!!.split(" ").map { it.toInt() }.reduce { a, b -> a + b }
        )
    }
}