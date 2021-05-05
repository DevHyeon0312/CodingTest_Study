package baekjoonSolution

fun main() {
    val (A,B,V) = readLine()!!.split(" ").map { it.toInt() }
    println(solution2869(A,B,V).totalDay())
}

class solution2869 constructor(val A: Int , val B: Int, val V: Int) {
    fun totalDay() : Int {
        val day = (V - B) / (A - B)
        val check = if ((V - B) % (A - B) == 0) 0 else 1
        return day + check
    }
}