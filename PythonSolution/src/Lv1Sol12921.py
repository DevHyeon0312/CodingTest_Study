# Created By DevHyeon on 2020.11.20
#  Question Title : 소수 찾기
#  Algorithm Type : Implementation
#  Level : 1
#  Link : https://programmers.co.kr/learn/courses/30/lessons/12921

def prime(n: int) -> bool:
    if n < 2:
        return False
    if n == 2:
        return True
    if n % 2 == 0:
        return False
    l = round(n ** 0.5) + 1
    for i in range(3, l, 2):
        if n % i == 0:
            return False
    return True


def solution(n):
    answer = 0
    for i in range(n+1):
        if prime(i) == True:
            answer = answer+1
    return answer