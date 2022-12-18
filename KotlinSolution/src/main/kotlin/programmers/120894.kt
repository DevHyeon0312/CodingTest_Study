package programmers

fun main() {
    `120894`().solution("onetwothreefourfivesixseveneightnine")
}

class `120894` {
    fun solution(numbers: String): Long {
        return numbers.englishToNumber().toLong()
    }

    private fun String.englishToNumber(): String =
        this.zeroToNumber()
            .oneToNumber()
            .twoToNumber()
            .threeToNumber()
            .fourToNumber()
            .fiveToNumber()
            .sixToNumber()
            .sevenToNumber()
            .eightToNumber()
            .nineToNumber()

    private fun String.zeroToNumber(): String = this.replace("zero","0")
    private fun String.oneToNumber(): String = this.replace("one","1")
    private fun String.twoToNumber(): String = this.replace("two","2")
    private fun String.threeToNumber(): String = this.replace("three","3")
    private fun String.fourToNumber(): String = this.replace("four","4")
    private fun String.fiveToNumber(): String = this.replace("five","5")
    private fun String.sixToNumber(): String = this.replace("six", "6")
    private fun String.sevenToNumber(): String = this.replace("seven", "7")
    private fun String.eightToNumber(): String = this.replace("eight","8")
    private fun String.nineToNumber(): String = this.replace("nine","9")
}