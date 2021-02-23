package baekjoonSolution

fun main() {
    val (A, B) = readLine()!!.split(" ").map { it.toInt() }

    val str = when {
        A == B -> { "==" }
        A > B -> { ">" }
        else -> { "<" }
    }

    println(str)
}