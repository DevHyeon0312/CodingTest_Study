package programmers

fun main() {
    Solution_42628().solution(
        arrayOf(
            "I 16","D 1"
        )
    )
}

class Solution_42628 {
    fun solution(operations: Array<String>): IntArray {
        val answer = arrayListOf<Int>()
        operations.map {
            it.split(" ")
        }.map {
            it[0] to it[1].toInt()
        }.forEach {
            if (it.first == "I") {
                answer.add(it.second)
            } else {
                val maxOrMin = if (it.second == 1) answer.max() else answer.min()
                maxOrMin?.let {
                    answer.remove(maxOrMin)
                }
            }
        }

        val max = answer.max() ?: 0
        val min = answer.min() ?: 0
        return intArrayOf(max, min)
    }
}