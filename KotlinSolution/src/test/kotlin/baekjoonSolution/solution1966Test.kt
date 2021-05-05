package baekjoonSolution

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class solution1966Test {

    @Test
    fun solution() {
        assertEquals(
            solution1966(1,0,listOf<Int>(5)).solution(), 1
        )
        assertEquals(
            solution1966(4,2,listOf<Int>(1,2,3,4)).solution(), 2
        )
        assertEquals(
            solution1966(6,0,listOf<Int>(1,1,9,1,1,1)).solution(), 5
        )
    }
}