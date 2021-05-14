package baekjoonSolution

fun main() {
    Solution4653().solution()
}

class Solution4653 {
    private val size = 10000
    private val selfNumbers = BooleanArray(size+1)
    fun solution() {
        checkNumber(size)

        for (index in 1 .. size) {
            if(!selfNumbers[index]) {
                println(index)
            }
        }
    }

    /** 셀프넘버가 아닌 숫자들을 true 로 변환 */
    private fun checkNumber(size: Int) {
        for (index in 1 until size) {
            var num = index
            while(true) {
                num = createNumber(num)
                if (num > size) {
                    break
                }
                selfNumbers[num] = true
            }
        }
    }

    /** 현재숫자의 다음 숫자 만들기 */
    private fun createNumber(number: Int): Int {
        return number + number.toString().split("").filter { it!="" }.sumBy { it.toInt() }
    }
}