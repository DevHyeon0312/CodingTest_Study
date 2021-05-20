package baekjoonSolution

fun main() {
    /** N, M 입력 */
    val (N,M) = readLine()!!.split(" ").map { it.toInt() }

    /** Array 입력 */
    val array = IntArray(N)
    for (i in 0 until N) {
        array[i] = readLine()!!.toInt()
    }

    /** 정렬: 내부적으로 퀵소트로 동작 */
    array.sort()

    /** 배열 출력 */
//    println(array.contentToString())

    /** 두수의 차이가 M 이상이면서 가장 적은 차이 구하기 */
    var min: Int = 2000000001
    for (i in array) {
        val index = array.lowerBound((i+M))
        if (index == array.size) continue
        if(array[index] - i < min) {
            min = array[index] - i
        }
    }
    println(min)
}

/** target 보다 크거가 같은 수중 가장 작은 수 */
fun IntArray.lowerBound(target: Int): Int {
    var begin = 0
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