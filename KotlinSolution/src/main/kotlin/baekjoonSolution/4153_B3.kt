package baekjoonSolution

fun main() {
    while (true) {
        val list = readLine()!!.split(" ").map { it.toDouble() }.sorted()

        if(list[0]==0.0 && list[1]==0.0 && list[2]==0.0) {
            break
        }

        if((list[0]*list[0] + list[1]*list[1]) == list[2]*list[2]) {
            println("right")
        } else {
            println("wrong")
        }
    }
}