package programmers

fun main() {
    println(
        Solution_81301().solution("one4seveneight")
    )
    println(
        Solution_81301().solution("23four5six7")
    )
    println(
        Solution_81301().solution("2three45sixseven")
    )
    println(
        Solution_81301().solution("123")
    )
}

class Solution_81301 {
    fun solution(s: String): Int {
        var newStr:String = s

        newStr = newStr.replace("zero","0")
        newStr = newStr.replace("one","1")
        newStr = newStr.replace("two","2")
        newStr = newStr.replace("three","3")
        newStr = newStr.replace("four","4")
        newStr = newStr.replace("five","5")
        newStr = newStr.replace("six","6")
        newStr = newStr.replace("seven","7")
        newStr = newStr.replace("eight","8")
        newStr = newStr.replace("nine","9")

        return newStr.toInt()
    }
}