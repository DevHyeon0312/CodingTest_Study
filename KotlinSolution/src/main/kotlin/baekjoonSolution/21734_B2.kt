package baekjoonSolution

import java.lang.StringBuilder


fun main() {
    val str = readLine()!!
    Solution21734(str).solution()
}

class Solution21734 constructor(private val str:String) {
    fun solution() {
        for (c in str) {
            val s = StringBuilder()
            for (i in 1..c.toInt().toSum()) {
                s.append(c)
            }
            println(s.toString())
        }
    }

    /** 아스키구하기 */
    private fun Char.toAscii() : Int {
        return this.toInt()
    }

    /** 각 자리수 합 */
    private fun Int.toSum() : Int {
        return this.toString().map { it.toInt()-48 }.sum()
    }
}