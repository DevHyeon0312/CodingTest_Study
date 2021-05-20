package baekjoonSolution

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    /** N, M 입력 */
    val stBlack = StringTokenizer(br.readLine(), " ")
    val N = stBlack.nextToken().toInt()
    val M = stBlack.nextToken().toInt()

    /** Array 입력 */
    val array = IntArray(N)
    for (i in 0 until N) {
        array[i] = StringTokenizer(br.readLine()).nextToken().toInt()
    }

    /** 정렬: 내부적으로 퀵소트로 동작 */
    array.sort()

    /** 두수의 차이가 M 이상이면서 가장 적은 차이 구하기 */
    var min: Int = Int.MAX_VALUE
    var start = 0
    for (i in array) {
        val index = array.lowerBound(start, (i+M))
        //차이가 M 이상이 없는 경우
        if (index == array.size) {
            break
        }

        //두 수 차이가 M 이면 중지
        if(min == M) {
            break
        }

        //차이가 M 이상이면서 min 보다 작은 경우
        if(array[index] - i < min) {
            min = array[index] - i
        }
        start = index
    }

    bw.write(min.toString())
    br.close()
    bw.close()
}

/** target 보다 크거가 같은 수중 가장 작은 수 */
fun IntArray.lowerBound(start:Int, target: Int): Int {
    //M 이상인 경우 왼쪽의 배열은 더이상 M 이상이 될 수 없으므로 탐색 대상에서 제거
    var begin = start
    var end: Int = this.size

    while (begin < end) {
        val mid = (begin + end) / 2
        if (this[mid] >= target) {
            end = mid
        } else {
            begin = mid + 1
        }
    }
    return end
}