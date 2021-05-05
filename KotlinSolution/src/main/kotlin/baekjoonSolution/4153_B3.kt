package baekjoonSolution

import kotlin.math.pow

fun main() {
    while (true) {
        val (A,B,C) = readLine()!!.split(" ").map { it.toDouble() }.sorted()

        if(A==0.0 && B==0.0 && C==0.0) {
            break
        }

        if(A.pow(2) + B.pow(2) == C.pow(2)) {
            println("right")
        } else {
            println("wrong")
        }
    }
}