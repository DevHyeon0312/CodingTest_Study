package programmers

import java.lang.StringBuilder

fun main() {
    println(
        `12951`().solution("abcd 3     s bc ")
    )
}
class `12951` {
    fun solution(s: String): String {
        val stringBuilder = StringBuilder()
        val arr = s.toLowerCase().split(" ")
        arr.forEachIndexed { index, s ->
            if (s.isNotEmpty()) {
                stringBuilder
                    .append(s[0].toUpperCase())
                    .append(s.substring(1))
            } else {
                stringBuilder
                    .append(s)
            }
            if (index != arr.size-1) {
                stringBuilder.append(" ")
            }
        }
        return stringBuilder.toString()
    }
}