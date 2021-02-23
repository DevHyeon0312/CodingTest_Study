package baekjoonSolution

fun main() {
    val (year) = readLine()!!.split(" ").map { it.toInt() }

    println( if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0 ) "1" else "0")

}