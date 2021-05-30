package baekjoonSolution

fun main() {
    val dp = IntArray(21)
    dp[0] = 0
    dp[1] = 1
    dp[2] = 1

    val N = readLine()!!.toInt()

    for (i in 3..N) {
        dp[i] = dp[i-1]+dp[i-2]
    }
    println(dp[N])
}