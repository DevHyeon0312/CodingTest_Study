package baekjoonSolution

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class solution2869Test {

    @Test
    fun totalDay() {
        assertEquals(solution2869(2, 1, 5).totalDay(), 4)
        assertEquals(solution2869(5, 1, 6).totalDay(), 2)
        assertEquals(solution2869(100, 99, 1000000000).totalDay(), 999999901)
        assertEquals(solution2869(10, 7, 15).totalDay(), 3)
        assertEquals(solution2869(50, 1, 100).totalDay(), 3)
        assertEquals(solution2869(2, 0, 5).totalDay(), 3)
    }
}