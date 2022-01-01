package programmers

fun main() {
    println(
        Solution_12947().solution(10)
    )
}
class Solution_12947 {
    fun solution(x: Int): Boolean {
        return x % (x.toString().map {it.toString().toInt() }.sum()) == 0
    }
}