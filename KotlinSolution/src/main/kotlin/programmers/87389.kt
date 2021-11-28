package programmers

fun main() {
    println(
        `87389`().solution(10)
    )
}

class `87389` {
    fun solution(n: Int): Int {
        var answer: Int = 0

        while(true) {
            answer++
            if(n % answer == 1) {
                break
            }
        }

        return answer
    }
}