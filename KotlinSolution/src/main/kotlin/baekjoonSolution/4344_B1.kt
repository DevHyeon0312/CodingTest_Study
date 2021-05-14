package baekjoonSolution

import java.text.DecimalFormat

fun main() {
    //TestCase
    val num = readLine()!!.toInt()
    for (i in 1..num) {
        val str = readLine()!!.split(" ").map { it.toInt() }
        val total = str[0]
        val scores = str.subList(1,str.size)
        println(
            Solution4344().solution(total, scores)
        )
    }
}

class Solution4344 {
    val DECIMAL_FORMAT = DecimalFormat("0.000%")
    /**
     * 평균을 넘는 학생들의 비율을 구해서 반환
     * input ex) 7 100 95 90 80 70 60 50 // input[0] 은 인원수, input[1] 부터 score
     * output ex) 57.143%
     * */
    fun solution(totalUser:Int, scores:List<Int>) : String {
        val aver = allAverage(totalUser, scores)
        val adobe = findAllAbodeAverage(aver, scores)
        val percent = percentage(totalUser, adobe)
        return DECIMAL_FORMAT.format(percent)
    }

    /**
     * n 명의 전체학생 평균
     * @param(totalUser: 전체인원수)
     * @param(scores: 얻은 점수)
     * input ex) allAverage(7, listOf(100, 95, 90, 80, 70, 60, 50))
     * return ex) 77.857......
     * */
    private fun allAverage(totalUser:Int, scores:List<Int>): Double {
        return scores.sum() / totalUser.toDouble()
    }

    /**
     * 평균이상의 인원수
     * @param(average : 평균)
     * @param(scores : 얻은 점수)
     * input ex) findAllAbodeAverage(77.857... , listOf(100, 95, 90, 80, 70, 60, 50))
     * return ex) 4
     * */
    private fun findAllAbodeAverage(average: Double, scores:List<Int>): Int {
        return scores.filter { it -> it > average }.count()
    }

    /**
     * 비율 구하기
     * @param(totalUser : 전체인원수)
     * @param(abodeUser : 평균이상 인원수)
     * input ex) percentage(7, 4)
     * return ex) 57.142........
     * */
    private fun percentage(totalUser: Int, abodeUser: Int) : Double {
        return abodeUser.toDouble() / totalUser.toDouble()
    }
}