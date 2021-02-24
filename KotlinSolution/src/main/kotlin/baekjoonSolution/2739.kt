package baekjoonSolution


fun main() {
    val (n) = readLine()!!.split(" ").map { it.toInt() }

    for (i in 1..9) {
        println("$n * $i = " + n*i)
    }
}