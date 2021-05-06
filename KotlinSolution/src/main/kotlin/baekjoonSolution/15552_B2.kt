package baekjoonSolution

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.StringBuilder
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val T = StringTokenizer(br.readLine()).nextToken().toInt()
    val stringBuilder =  StringBuilder()

    for (i in 0 until T) {
        val tokenizer = StringTokenizer(br.readLine())
        val SUM = tokenizer.nextToken().toInt() + tokenizer.nextToken().toInt()
        stringBuilder.append(SUM)
        stringBuilder.append("\n")
    }

    bw.write(stringBuilder.toString())
    br.close()
    bw.close()
}