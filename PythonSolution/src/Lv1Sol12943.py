# Created By DevHyeon on 2020.11.21
#  Question Title : 콜라츠 추측
#  Algorithm Type : Implementation
#  Level : 1
#  Link : https://programmers.co.kr/learn/courses/30/lessons/12943

def solution(num):
    answer = -1
    a = num
    for i in range(500):
        if a == 1:
            return i
        if a % 2 == 0:
            a = a / 2
        else:
            a = a * 3 + 1

    return answer