package baekjoonSolution


fun main() {
    var list = MutableList<Int>(0,{0})
    for (i in 1..9) {
        var (x) = readLine()!!.split(" ").map { it.toInt() }
        list.add(x)
    }

    val max = list.maxOrNull()
    val index = list.indexOf(max)+1
    println(max)
    println(index)
}