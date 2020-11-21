# Created By DevHyeon on 2020.11.21
#  Question Title : x만큼 간격이 있는 n개의 숫자
#  Algorithm Type : Implementation
#  Level : 1
#  Link : https://programmers.co.kr/learn/courses/30/lessons/12954
def solution(x, n):
    answer = []

    for i in range(1,n+1):
        answer.append(x*i)

    return answer