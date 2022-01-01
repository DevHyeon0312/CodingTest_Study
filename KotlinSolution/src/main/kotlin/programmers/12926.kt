package programmers


fun main() {
    println(
        `12926`().solution("AB",1)
    )
    println(
        `12926`().solution("z",1)
    )
    println(
        `12926`().solution("a B z",4)
    )
}
class `12926` {

    //s 는 8000이하, n은 1이상 25이하 (25이하라는 것은, 절대 두바퀴 돌수는 없네)
    fun solution(s: String, n: Int): String {
        val stringBuilder = StringBuilder()
        s.forEach {
            when(it.toInt()) {
                in 65..90 -> {
                    stringBuilder.append(
                        it.moveCapitalLetter(n)
                    )
                }
                in 97..122 -> {
                    stringBuilder.append(
                        it.moveSmallLetter(n)
                    )
                }
                else -> {
                    stringBuilder.append(
                        it.moveBlank(n)
                    )
                }
            }
        }
        return stringBuilder.toString()
    }

    //대문자를 n 만큼 이동
    private fun Char.moveCapitalLetter(n: Int): Char {
        val result = this.toInt() + n
        return if (result > 90) {
            (result-26).toChar()
        } else {
            result.toChar()
        }
    }

    //소문자를 n 만큼 이동
    private fun Char.moveSmallLetter(n: Int): Char {
        val result = this.toInt() + n
        return if (result > 122) {
            (result-26).toChar()
        } else {
            result.toChar()
        }
    }

    //공백을 n만큼 이동
    private fun Char.moveBlank(n: Int): Char = ' '
}