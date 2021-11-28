package programmers

fun main() {
    println(
        `12935`().solution(
            intArrayOf(10,10)
        ).contentToString()
    )
}

class `12935` {
    fun solution(arr: IntArray): IntArray {
        return arr.removeMinNumber()
    }

    private fun IntArray.removeMinNumber(): IntArray {
        val minNumber = this.minOrNull() //제출은 코틀린 버전에 의하여 .min() 사용
        val newArr = this.filter { it != minNumber }.toIntArray()
        return if(newArr.isNotEmpty()) {
            newArr
        } else {
            intArrayOf(-1)
        }
    }
}