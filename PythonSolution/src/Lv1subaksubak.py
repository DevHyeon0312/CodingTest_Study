# Created By DevHyeon on 2020.11.20
#  Question Title : 수박수박수박수박수박수?
#  Algorithm Type : Implementation
#  Level : 1
#  Link : https://programmers.co.kr/learn/courses/30/lessons/12922
def solution(n):
    answer = ''
    i = 0
    j = 1
    while (i < n):
        if (j == 1):
            answer = answer + '수'
            j = 0
        else:
            answer = answer + '박'
            j = 1
        i = i + 1

    return answer