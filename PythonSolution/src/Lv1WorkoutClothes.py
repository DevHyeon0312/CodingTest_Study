#
# Created By DevHyeon on 2020.11.19
#  Question Title : 체육복
#  Algorithm Type : Greedy
#  Level : 1
#  Link : https://programmers.co.kr/learn/courses/30/lessons/42862
#
def solution(n, lost, reserve):
    answer = 0
    stu = set(reserve[:]) - set(lost[:])
    stu_lost = set(lost[:]) - set(reserve[:])

    for i in stu:
        if i - 1 in stu_lost:
            stu_lost.remove(i - 1)
        elif i + 1 in stu_lost:
            stu_lost.remove(i + 1)

    answer = n - len(stu_lost)
    return answer