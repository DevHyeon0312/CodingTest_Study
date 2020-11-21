# Created By DevHyeon on 2020.11.21
#  Question Title : 자릿수 더하기
#  Algorithm Type : Implementation
#  Level : 1
#  Link : https://programmers.co.kr/learn/courses/30/lessons/12931
def solution(n):
    answer = 0
    n = str(n)

    for i in n:
        answer = answer + int(i)

    return answer