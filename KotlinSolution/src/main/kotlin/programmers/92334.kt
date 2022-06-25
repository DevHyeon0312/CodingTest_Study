package programmers

fun main() {
    val idList = arrayOf(
        "muzi", "frodo", "apeach", "neo"
    )
    val report = arrayOf(
        "muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi","muzi frodo"
    )
    val k = 2

    println(
        `92334`().solution(
            id_list = idList,
            report = report,
            k = k
        ).contentToString()
    )
}


class `92334` {
    fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
        //신고받은유저 : 신고한유저목록
        val reportUserList : MutableMap<String, MutableList<String>> = mutableMapOf()

        //UserId (id_list)
        id_list.forEach {
            reportUserList[it] = mutableListOf()
        }

        //UserReport (report)
        val distinctReport = report.distinct()
        distinctReport.forEach { rep ->
            rep.split(" ").apply {
                reportUserList[this[1]]?.add(this[0])
            }
        }

        //Report Max Count (k) -> MailUser
        val answer = IntArray(id_list.size)
        reportUserList.filter {it.value.size >= k }.forEach {
            it.value.forEach { userId ->
                val idx = id_list.indexOf(userId)
                answer[idx]++
            }
        }
        return answer
    }
}
