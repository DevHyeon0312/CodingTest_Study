package baekjoonSolution

fun main() {
    //input : T(테스트 케이스) , k(층) , n(호수)
    //output : 각각의 테스트케이스에 대해서 해당 집에 거주민 수를 출력하라.
    val T = readLine()!!.toInt()
    for (i in 1..T) {
        val k = readLine()!!.toInt()
        val n = readLine()!!.toInt()
        println(solution2775(k,n).loadResidentNumber())
    }

}

class solution2775 constructor(val k: Int , val n: Int) {

    /** 거주민 수 출력 */
    fun loadResidentNumber() : Int {
        //2차원 배열 생성
        var array = createApartment()
        //1층 초기화
        array = addApartmentFirstFloor(array)

        //구해야 하는 층과 호수까지 계산
        array = addApartmentFloor(array)

        return array[k][n]
    }

    /** 아파트 2차원 배열 생성 */
    fun createApartment() : Array<IntArray>  {
        return Array(k+1) { IntArray(n+1) }
    }

    /** 1층에 인원수 배정 */
    fun addApartmentFirstFloor(apartment : Array<IntArray>) : Array<IntArray> {
        for (i in 0 .. n) {
            apartment[0][i] = i
        }
        return apartment
     }

    /** n층에 인원수 배정 */
    fun addApartmentFloor(apartment : Array<IntArray>) : Array<IntArray> {
        for (floor in 1 .. k) {
            for (i in 0 .. n) {
                for (j in 0 .. i) {
                    apartment[floor][i] += apartment[floor-1][j]
                }
            }
        }
        return apartment
    }
}