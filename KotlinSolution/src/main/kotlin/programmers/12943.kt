package programmers

fun main() {
    println(
        `12943`().solution(1)
    )
}

class `12943` {
    fun solution(num: Int): Int {
        if(num == 1) return 0
        var answer = num.toLong()
        var cnt = 1
        while(cnt < 474) {
            answer = if (answer % 2 == 0L) {
                (answer / 2)
            } else {
                (answer * 3) + 1
            }

            if(answer == 1L) {
                return cnt
            }
            cnt++
        }
        return -1
    }
}