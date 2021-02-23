package baekjoonSolution

fun main() {
//    println("main Started")

    val (N, M) = readLine()!!.split(" ").map { it.toInt() }
    var cards = readLine()!!.split(" ").map { it.toInt() }.toList()

    var max = 0
    for (i in 0..N-3) {
        for (j in i+1 .. N-2) {
            for (k in j+1 until N) {
                val temp = cards[i] + cards[j] + cards[k]
                if (temp > M) continue
                else {
                    max = if (max < temp) temp else max
                }
            }
        }
    }

    println(max)
}