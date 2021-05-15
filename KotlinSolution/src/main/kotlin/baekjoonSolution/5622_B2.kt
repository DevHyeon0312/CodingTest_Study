package baekjoonSolution


fun main() {
    val str = readLine()!!.toString()
    println(Solution5622().solution(str))
}


class Solution5622 {
    val number = IntArray(26)
    fun solution(str: String): Int {
        dialSet()
        var sum = 0
        for (c in str) {
            sum += number[c.toInt()-65]
        }
        return sum
    }

    fun dialSet() {
        number[0] = 3//A
        number[1] = 3//B
        number[2] = 3//C
        number[3] = 4//D
        number[4] = 4//E
        number[5] = 4//F
        number[6] = 5//G
        number[7] = 5//H
        number[8] = 5//I
        number[9] = 6//J
        number[10] = 6//K
        number[11] = 6//L
        number[12] = 7//M
        number[13] = 7//N
        number[14] = 7//O
        number[15] = 8//P
        number[16] = 8//Q
        number[17] = 8//R
        number[18] = 8//S
        number[19] = 9//T
        number[20] = 9//U
        number[21] = 9//V
        number[22] = 10//W
        number[23] = 10//X
        number[24] = 10//Y
        number[25] = 10//Z
    }
}