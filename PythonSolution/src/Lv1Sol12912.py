# Created By DevHyeon on 2020.11.18
#  Question Title : 두 정수 사이의 합
#  Algorithm Type : Implementation
#  Level : 1
#  Link : https://programmers.co.kr/learn/courses/30/lessons/12912
def solution(a, b):
    i = a if a>b else b
    j = b if a>b else a
    temp = 0
    while(j<=i):
        temp = temp + j
        j=j+1

    return temp