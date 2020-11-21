# Created By DevHyeon on 2020.11.21
#  Question Title : 하샤드 수
#  Algorithm Type : Implementation
#  Level : 1
#  Link : https://programmers.co.kr/learn/courses/30/lessons/12947
def solution(x):
    answer = True
    k = str(x)
    sum = 0
    for i in k:
        sum = sum + int(i)

    if (x % sum != 0):
        return False
    return answer