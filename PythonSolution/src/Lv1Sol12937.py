# Created By DevHyeon on 2020.11.21
#  Question Title : 짝수와 홀수
#  Algorithm Type : Implementation
#  Level : 1
#  Link : https://programmers.co.kr/learn/courses/30/lessons/12937
def solution(num):
    answer = 'Odd'
    if (num % 2 == 0):
        answer = 'Even'

    return answer