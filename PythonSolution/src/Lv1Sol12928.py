# Created By DevHyeon on 2020.11.21
#  Question Title : 약수의 합
#  Algorithm Type : Implementation
#  Level : 1
#  Link : https://programmers.co.kr/learn/courses/30/lessons/12928
def solution(n):
    i = 0
    sum = 0
    while (i < n):
        i = i + 1
        if (n % i == 0):
            sum = sum + i

    answer = sum
    return answer