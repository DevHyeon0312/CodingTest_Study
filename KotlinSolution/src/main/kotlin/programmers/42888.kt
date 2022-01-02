package programmers

fun main() {
    println(
        `42888`().solution(
            arrayOf(
                "Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"
            )
        ).contentToString()
    )
}


class `42888` {
    fun solution(record: Array<String>): Array<String> {
        //입장,퇴장,변경 uid 기록
        val recordList = mutableListOf<Triple<String,String,String>>()

        //uid 당 마지막 닉네임
        val nickNameMap = mutableMapOf<String,String>()

        //record 전환
        record.forEach {
            val str = it.split(" ")
            lateinit var rec : Triple<String,String,String>
            if (str.size == 3) {
                rec = Triple(str[0], str[1], str[2])
                recordList.add(rec)
                nickNameMap[rec.second] = rec.third
            } else {
                rec = Triple(str[0], str[1], "")
                recordList.add(rec)
            }
        }

        //결과
        val result = mutableListOf<String>()
        recordList.forEach {
            when(it.first) {
                "Enter" -> {
                    result.add("${nickNameMap[it.second]}님이 들어왔습니다.")
                }
                "Leave" -> {
                    result.add("${nickNameMap[it.second]}님이 나갔습니다.")
                }
            }
        }
        return result.toTypedArray()
    }
}