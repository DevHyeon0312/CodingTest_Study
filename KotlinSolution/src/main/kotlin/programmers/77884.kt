package programmers

fun main() {
    println(Solution_77884().solution(13, 17))
}

class Solution_77884 {

    /** 약수의 개수가 짝이면 +, 홀이면 - */
    fun solution(left: Int, right: Int): Int {
        var answer = 0

        for (i in left .. right) {
            if(countDivisors(i) % 2 == 0) {
                answer += i
            } else {
                answer -= i
            }
        }

        return answer
    }

    /** 약수의 개수 */
    private fun countDivisors(num: Int): Int {
        var count = 0

        val size = Math.sqrt(num.toDouble()).toInt()
        for(i in 1..size) {
            if(num%i == 0) {
                if(num / i == i) {
                    count++
                } else {
                    count += 2
                }
            }
        }

        return count
    }
}