package baekjoonSolution

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Solution4344Test {

    @Test
    fun solution() {
        val str =  "5 50 50 70 80 100".split(" ").map { it.toInt() }
        val total = str[0]
        val scores = str.subList(1,str.size)
        assertEquals(Solution4344().solution(total, scores), "40.000%")

        val str2 =  "7 100 95 90 80 70 60 50".split(" ").map { it.toInt() }
        val total2 = str2[0]
        val scores2 = str2.subList(1,str2.size)
        assertEquals(Solution4344().solution(total2, scores2), "57.143%")


        val str3 =  "3 70 90 80".split(" ").map { it.toInt() }
        val total3 = str3[0]
        val scores3 = str3.subList(1,str3.size)
        assertEquals(Solution4344().solution(total3, scores3), "33.333%")


        val str4 =  "3 70 90 81".split(" ").map { it.toInt() }
        val total4 = str4[0]
        val scores4 = str4.subList(1,str4.size)
        assertEquals(Solution4344().solution(total4, scores4), "66.667%")

        val str5 =  "9 100 99 98 97 96 95 94 93 91".split(" ").map { it.toInt() }
        val total5 = str5[0]
        val scores5 = str5.subList(1,str5.size)
        assertEquals(Solution4344().solution(total5, scores5), "55.556%")
    }
}