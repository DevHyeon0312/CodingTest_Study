package baekjoonSolution

fun main() {
    val T = readLine()!!.toInt()
    for (i in 1 .. T) {
        val (A,B) = readLine()!!.split(" ").map { it.toInt() }
        println(Solution11021(i,A,B).print())
    }
}

class Solution11021 constructor(private val index:Int, private val A:Int, private val B:Int) {
    fun print() : String {
        return StringBuilder().append("Case #").append(index).append(": ").append((A+B)).toString()
    }
}