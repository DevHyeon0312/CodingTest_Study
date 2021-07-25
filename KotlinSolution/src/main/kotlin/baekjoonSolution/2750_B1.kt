package baekjoonSolution


fun main() {
    val n = readLine()!!.toInt()

    val list : MutableList<Int> = mutableListOf()
    for (i in 0 until n) {
        list.add(
            readLine()!!.toInt()
        )
    }
    solution2750().solution(list)
}

class solution2750 {
    fun solution(list: MutableList<Int>) {
        list.sort()
        list.forEach {
            println(it)
        }
    }
}