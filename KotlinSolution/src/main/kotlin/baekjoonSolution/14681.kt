package baekjoonSolution

fun main() {
    val (x) = readLine()!!.split(" ").map { it.toInt() }
    val (y) = readLine()!!.split(" ").map { it.toInt() }

    val quadrant = when {
        x > 0 && y > 0 -> { "1" }
        x < 0 && y > 0 -> { "2" }
        x < 0 && y < 0 -> { "3" }
        else -> { "4" }
    }

    println(quadrant)
}