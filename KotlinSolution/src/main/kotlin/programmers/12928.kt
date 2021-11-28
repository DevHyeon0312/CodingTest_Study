package programmers

fun main() {
    println(
        `12928`().solution(12)
    )
    println(
        `12928`().solution(5)
    )
}
class `12928` {
    fun solution(n: Int): Int {
        return n.sumOfDivisors()
    }

    private fun Int.sumOfDivisors(): Int {
        var sum = 0
        return if (this == 0) {
            sum
        } else {
            for (i in 1..this) {
                when {
                    i * i > this -> {
                        sum
                    }
                    i * i == this -> {
                        sum += i
                    }
                    this % i == 0 -> {
                        sum += i + this / i
                    }
                }
            }
            sum
        }
    }
}