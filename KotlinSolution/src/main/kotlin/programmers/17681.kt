package programmers

import java.lang.StringBuilder

fun main() {

    val n = 5
    val arr1:IntArray = intArrayOf(1, 20, 28, 18, 11)
    val arr2:IntArray = intArrayOf(3, 1, 21, 17, 28)
    Solution_17681().solution(n,arr1,arr2)
}

class Solution_17681 {
    fun solution(n: Int, arr1: IntArray, arr2: IntArray) {
        val list = ArrayList<String>()
        for (i in 0 until n) {
            (arr1[i] or arr2[i])
                .toBinary()
                .fillFrontZero(n)
                .changeWallMap {
                    list.add(it)
                }
        }
        println(list.toString())
    }
}

/** 10진수를 2진수로 변환 */
fun Int.toBinary(): String {
    return this.toString(2)
}

/** 2진수의 길이가 n 보다 작으면, 앞을 0으로 채움 */
fun String.fillFrontZero(n:Int): String {
    val sb = StringBuilder()

    for(i in this.length until n) {
        sb.append(0)
    }
    sb.append(this)

    return sb.toString()
}

/** 2진수의 1을 #(벽) 으로, 0을 공백(길) 인 지도로 변환 */
fun String.changeWallMap(complete: (String) -> Unit) {
    complete(
        this.replace("1","#")
            .replace("0"," ")
    )
}