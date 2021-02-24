package baekjoonSolution


fun main() {
    val (h, m) = readLine()!!.split(" ").map { it.toInt() }

    var nm = if (m >= 45) m-45 else m+15
    var nh = if (m >= 45) h else h-1
    nh = if (nh < 0) 23 else nh

    println("$nh $nm")
}