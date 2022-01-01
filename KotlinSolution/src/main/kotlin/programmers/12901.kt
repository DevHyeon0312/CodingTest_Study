package programmers

import java.time.LocalDate

fun main() {
    println(
        Solution_12901().solution(1,3)
    )
    println(
        Solution_12901().solution(5,24)
    )
}

class Solution_12901 {
    fun solution(a: Int, b: Int): String {
        return getDayName(2016,a,b)
    }

    private fun getDate(year: Int, month: Int, day: Int) = LocalDate.of(year,month,day)
    private fun getDayOfWeek(year: Int, month: Int, day: Int) = getDate(year, month, day).dayOfWeek
    private fun getDayName(year: Int, month: Int, day: Int) = getDayOfWeek(year, month, day).name.substring(0,3)
}