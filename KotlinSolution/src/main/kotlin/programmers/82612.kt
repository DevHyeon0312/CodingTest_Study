package programmers

fun main() {

}

class `82612` {
    fun solution(price: Int, money: Int, count: Int): Long {
        val totalPrice = getTotalPrice (price.toLong(), count.toLong())
        return getShortageMoney(totalPrice, money)
    }

    /** 총 놀이기구 이용료 반환 */
    private fun getTotalPrice(price: Long, count: Long): Long {
        return (count * (count + 1) / 2 * price)
    }

    /** 부족한 금액 반환 */
    private fun getShortageMoney (total: Long, money: Int): Long {
        return if (money - total < 0) total - money else 0
    }
}