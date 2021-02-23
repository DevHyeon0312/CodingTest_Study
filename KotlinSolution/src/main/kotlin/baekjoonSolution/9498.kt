package baekjoonSolution

fun main() {
    val (grade) = readLine()!!.split(" ").map { it.toInt() }

    when {
        grade >= 90 -> {
            println("A")
        }
        grade >= 80 -> {
            println("B")
        }
        grade >= 70 -> {
            println("C")
        }
        grade >= 60 -> {
            println("D")
        }
        else -> {
            println("F")
        }
    }
}