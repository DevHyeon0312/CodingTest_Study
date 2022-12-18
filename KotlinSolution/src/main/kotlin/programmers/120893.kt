package programmers

fun main() {

}

class `120893` {
    fun solution(my_string: String): String {
        val stringBuilder = StringBuilder()
        my_string.forEach {
            if (it.toInt() <= 90) {
                stringBuilder.append(it.toUpperCase())
            } else {
                stringBuilder.append(it.toLowerCase())
            }
        }
        return stringBuilder.toString()
    }
}