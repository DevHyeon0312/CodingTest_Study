package baekjoonSolution

fun main() {
    val str = readLine()!!
    Solution2941(str).solution()
}

class Solution2941 constructor(private val str:String) {
    fun solution() {
        println(
            str.toAlphabet().length
        )
    }

    /** 크로아티아 알파벳 변경 */
    private fun String.toAlphabet() : String {
        return this
            .replace("c=","1")
            .replace("c-","1")
            .replace("dz=","1")
            .replace("d-","1")
            .replace("lj","1")
            .replace("nj","1")
            .replace("s=","1")
            .replace("z=","1")

    }
}