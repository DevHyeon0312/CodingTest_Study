# Created By DevHyeon on 2020.11.21
#  Question Title : 정수 제곱근 판별
#  Algorithm Type : Implementation
#  Level : 1
#  Link : https://programmers.co.kr/learn/courses/30/lessons/12934

import math

def solution(n):
    answer = 0
    answer=math.pow(math.sqrt(n)+1,2)
    if int(answer) != answer:
        return -1
    return answer