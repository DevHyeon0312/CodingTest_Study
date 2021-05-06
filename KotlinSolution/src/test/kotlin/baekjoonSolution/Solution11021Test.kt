package baekjoonSolution

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Solution11021Test {

    @Test
    fun print() {

        assertEquals(
            Solution11021(1,1, 1).print() , "Case #1: 2"
        )
        assertEquals(
            Solution11021(2,2,3).print() , "Case #2: 5"
        )
        assertEquals(
            Solution11021(3,3,4).print() , "Case #3: 7"
        )
        assertEquals(
            Solution11021(4,9,8).print() , "Case #4: 17"
        )
        assertEquals(
            Solution11021(5,5,2).print() , "Case #5: 7"
        )
    }
}