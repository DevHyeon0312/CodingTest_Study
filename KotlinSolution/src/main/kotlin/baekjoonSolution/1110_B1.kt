package baekjoonSolution

fun main() {
    val num = readLine()!!.toInt()
    println(
        Solution1110(num).solution()
    )
}

class Solution1110 constructor(private val number : Int) {
    fun solution() : Int {
        var count = 1
        var num = number

        return if (number == 0) {
            count
        } else {
            num = getCycle(num)
            while (true) {
                count++
                num = getCycle(num)
                if(num == number) {
                    break
                }
            }
            count
        }
    }

    fun getCycle(number: Int): Int {
        var result: Int = 0

        var lastNum: Int  = 0

        for(num in number.toString().split("").filter { it != "" }) {
            lastNum = num.toInt()
            result += num.toInt()
        }

        return (lastNum.toString() + (result%10).toString()).toInt()
    }
}