package baekjoonSolution

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class solution2775Test {
    @Test
    fun loadResidentNumber() {
        //1층 3호 인원 = 6이어야함
        assertEquals(solution2775(1,3).loadResidentNumber(), 6)
        //2층 3호 인원 = 10이어야함
        assertEquals(solution2775(2,3).loadResidentNumber(), 10)
    }
}