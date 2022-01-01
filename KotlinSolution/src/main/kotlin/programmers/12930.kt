package programmers

class Solution_12930 {
    fun solution(s: String): String {
        val stringBuilder = StringBuilder()
        var startIndex = 0
        s.forEach {c ->
            if (c == ' ') {
                startIndex = 0
                stringBuilder.append(c)
            } else {
                if (startIndex%2 == 0) {
                    stringBuilder.append(c.toUpperCase())
                } else {
                    stringBuilder.append(c.toLowerCase())
                }
                startIndex++
            }
        }
        return stringBuilder.toString()
    }
}