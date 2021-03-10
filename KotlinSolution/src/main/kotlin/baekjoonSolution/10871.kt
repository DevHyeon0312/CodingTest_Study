package baekjoonSolution


fun main() {
    val (N, X) = readLine()!!.split(" ").map { it.toInt() }

    val list = readLine()!!.split(" ").map { it.toInt() }.toList()

    for (item in list) {
        if (item < X) {
            print("$item ")
        }
    }
}