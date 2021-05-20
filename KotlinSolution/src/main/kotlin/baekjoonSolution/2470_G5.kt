package baekjoonSolution

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.abs

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))


    /** N 입력 */
    val N = StringTokenizer(br.readLine()).nextToken().toInt()

    /** Array 입력 */
    val array = IntArray(N)
    val stBlack = StringTokenizer(br.readLine(), " ")
    for (i in 0 until N) {
        array[i] = stBlack.nextToken().toInt()
    }

    /** 정렬 */
    array.sort()

    /** 정답구하기 */
    val res = solution(array)
    bw.write("" + res[0] + " " + res[1])
    br.close()
    bw.close()
}


fun solution(array: IntArray): IntArray {
    Arrays.sort(array)
    var lp = 0
    var rp: Int = array.size - 1
    var sum = Int.MAX_VALUE
    var lsave = 0
    var rsave = 0

    while (lp != rp) {
        val temp = array[lp] + array[rp]
        if (temp == 0) {
            lsave = lp
            rsave = rp
            break
        } else if (temp > 0) {
            if (abs(sum) > abs(temp)) {
                sum = temp
                lsave = lp
                rsave = rp
            }
            rp--
        } else {
            if (abs(sum) > abs(temp)) {
                sum = temp
                lsave = lp
                rsave = rp
            }
            lp++
        }
    }

    val result = IntArray(2)
    result[0] = array[lsave].coerceAtMost(array[rsave])
    result[1] = array[lsave].coerceAtLeast(array[rsave])
    return result
}