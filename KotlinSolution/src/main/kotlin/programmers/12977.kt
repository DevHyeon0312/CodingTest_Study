package programmers

import java.util.*


fun main() {
    val array : IntArray = intArrayOf(1,2,3,4)
    val array2 : IntArray = intArrayOf(1,2,7,6,4)
    println(
        Solution_12977().solution(array)
    )

    println(
        Solution_12977().solution(array2)
    )
}

class Solution_12977 {
    fun solution(nums: IntArray): Int {
        var answer = 0

        combResultList(nums.toList()) { completion ->
            completion.forEach {
                val sum = it.sum()
                isPrime(sum) { completion ->
                    if(completion) {
                        answer++
                    }
                }
            }
        }

        return answer
    }

    /** 조합결과모음
     * combResultList (
     *      list: List<Int>  : List<Int> 는 자료형 변환 가능
     * )
     * */
    private fun combResultList(list: List<Int>, completion: (List<List<Int>>) -> Unit) {
        val answer = mutableListOf<List<Int>>()
        combination(answer, list, Array<Boolean>(list.size) { false }, 0,  3)
        completion(answer)
    }

    /** 조합
     * combination (
     *      answer  : 조합의 결과를 저장하는 이중 리스트,
     *      el      : 조합을 구할 원소들의 집합,
     *      ck      : 원소 선택 여부를 확인하기 위한 배열,
     *      start   : 탐색 시작 인덱스,
     *      target  : 구할 조합의 원소 개수
     *      }
     * */
    private fun <T> combination(answer: MutableList<List<T>>, el: List<T>, ck: Array<Boolean>, start: Int, target: Int) {
        if(target == 0) {
            answer.addAll( listOf(el.filterIndexed { index, t -> ck[index] }) )
        } else {
            for(i in start until el.size) {
                ck[i] = true
                combination(answer, el, ck, i + 1, target - 1)
                ck[i] = false
            }
        }
    }

    /** 소수판별 */
    private fun isPrime(num: Int, completion: (Boolean) -> Unit) {
        var i = 2
        while (i * i <= num) {
            if (num % i == 0) {
                completion(false)
                return
            }
            i += 1
        }
        completion(true)
    }

}