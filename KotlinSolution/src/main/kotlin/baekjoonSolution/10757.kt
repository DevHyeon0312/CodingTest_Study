package baekjoonSolution

fun main() = print (
    readLine()!!
        .split(" ")
        .map {
            it.toInt()
        }
        .fold(10) { sum,
                    num -> sum + num
        }
)