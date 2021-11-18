package programmers

import kotlin.math.pow
import kotlin.math.sqrt

fun main() {
    for (i in 1..16) {
        println(
            "$i : "+`12934`().solution(i.toLong())
        )
    }
}

class `12934` {
    fun solution(n: Long): Long {
        val sqrt = sqrt(n.toDouble()).toLong()
        val num = if (sqrt*sqrt == n) sqrt else -1
        return if(num == -1L) -1 else (num+1) * (num+1)
    }
}