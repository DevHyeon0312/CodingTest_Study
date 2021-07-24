package baekjoonSolution

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val N = br.readLine().toInt()

    val list : MutableList<Int> = mutableListOf()
    for (i in 0 until N) {
        list.add(
            br.readLine().toInt()
        )
    }

    val builder = StringBuilder()
    list.sort()
    list.forEach {
        builder.append(it).append("\n")
    }

    bw.write(builder.toString())

    bw.close()
    br.close()
}