package baekjoonSolution

import java.util.*


fun main() {
    val T = readLine()!!.toInt()
    val priQueue = PriorityQueue<Int>(Collections.reverseOrder())
    for (i in 0 until T) {
        readLine()!!.split(" ").map { priQueue.add(it.toInt()) }
    }

    for (i in 1 until T) {
        priQueue.poll()
    }

    println(priQueue.poll().toString())
}