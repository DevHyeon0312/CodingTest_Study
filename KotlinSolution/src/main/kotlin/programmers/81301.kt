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
    println(
        Solution_81301().solution("1zero4")
    )
}

class Solution_81301 {
    fun solution(s: String): Int {

        var index = 0
        val size = s.length-1
        var result = 0
        while (index <= size) {
            var next : Pair<Int, Int>
            when(s[index]) {
                'z' -> {
                    next = changeZero()
                }
                'o' -> {
                    next = changeOne()

                }
                't' -> {
                    next = if (s[index+1] == 'w') {
                        changeTwo()
                    } else {
                        changeThree()
                    }
                }
                'f' -> {
                    next = if (s[index+1] == 'o') {
                        changeFour()
                    } else {
                        changeFive()
                    }
                }
                's' -> {
                    next = if(s[index+1] == 'i') {
                        changeSix()
                    } else {
                        changeSeven()
                    }
                }
                'e' -> {
                    next = changeEight()
                }
                'n' -> {
                    next = changeNine()
                }
                else -> {
                    next = Pair(s[index].toInt()-48,1)
                }
            }
            result = result*10 + next.first
            index += next.second
        }
        return result
    }
    private fun changeZero(): Pair<Int, Int> =  Pair(0,4)
    private fun changeOne(): Pair<Int, Int> = Pair(1,3)
    private fun changeTwo(): Pair<Int, Int> = Pair(2,3)
    private fun changeThree(): Pair<Int, Int> = Pair(3,5)
    private fun changeFour(): Pair<Int, Int> = Pair(4,4)
    private fun changeFive(): Pair<Int, Int> = Pair(5,4)
    private fun changeSix(): Pair<Int, Int> = Pair(6,3)
    private fun changeSeven(): Pair<Int, Int> = Pair(7,5)
    private fun changeEight(): Pair<Int, Int> = Pair(8,5)
    private fun changeNine(): Pair<Int, Int> = Pair(9,4)

}