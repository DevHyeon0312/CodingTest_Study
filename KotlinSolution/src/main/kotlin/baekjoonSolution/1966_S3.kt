package baekjoonSolution

import java.util.*

fun main() {
    val T = readLine()!!.toInt()
    for (i in 1..T) {
        val (k,n) = readLine()!!.split(" ").map { it.toInt() }
        val pri = readLine()!!.split(" ").map { it.toInt() }
        println(solution1966(k,n,pri).solution())
    }
}

class solution1966 constructor(val N: Int , val M: Int, val PRI : List<Int>) {
    fun solution() : Int {
        var printQueue = createPrintQueue()
        var count = 0
        while(true) {
            val max = printQueue.maxOfOrNull {
                it.PRI
            }
            if(printQueue.peek().PRI == max) {
                count+=1
                if(printQueue.peek().NAME == M) {
                    break
                }
                printQueue = outPrint(printQueue)
            } else {
                printQueue = backPrint(printQueue)
            }
        }
        return count
    }
    private fun createPrintQueue() : Queue<DOC> {
        val queue : Queue<DOC> = LinkedList()
        for (i : Int in 0 until N) {
            queue.add(DOC(i,PRI[i]))
        }
        return queue
    }

    private fun backPrint(queue : Queue<DOC>) : Queue<DOC> {
        val checkDOC = queue.peek()
        queue.add(checkDOC)
        queue.poll()
        return queue
    }

    private fun outPrint(queue : Queue<DOC>) : Queue<DOC> {
        queue.poll()
        return queue
    }
}

data class DOC(
    val NAME : Int,
    val PRI : Int
)