package programmers

fun main() {
    println(
        `12945`().solution(100000)
    )
}
class `12945` {
    fun solution(n: Int): Int {
        val dp = IntArray(n+1)
        dp[0] = 0
        dp[1] = 1
        for (i in 2 .. n) {
            dp[i] = dp[i-2] % 1234567 + dp[i-1] % 1234567
        }
        return dp[n] % 1234567
    }
}