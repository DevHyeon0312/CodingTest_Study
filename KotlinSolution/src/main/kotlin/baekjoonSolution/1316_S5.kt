package baekjoonSolution

fun main() {
    val T = readLine()!!.toInt()
    var sum = 0
    for (i in 0 until T) {
        val str = readLine()!!
        if(Solution1316(str).solution()) {
            sum++
        }
    }
    println(sum)
}

class Solution1316 constructor(private val str:String) {
    fun solution() : Boolean {
        return str.isGroup()
    }

    /** 그룹단어 체크
     * 그룹단어: 동일한 알파벳은 서로 이어져 있는 단어
     * */
    fun String.isGroup() : Boolean {
        val array = IntArray(26) {-1}

        var index = 0
        for (c in this) {
            if(array[c.toInt()-97] != -1 && array[c.toInt()-97] < index-1) {
                return false
            } else {
                array[c.toInt()-97] = index++
            }
        }
        return true
    }
}