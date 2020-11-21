# Created By DevHyeon on 2020.11.21
#  Question Title : 정수 내림차순으로 배치하기
#  Algorithm Type : Implementation
#  Level : 1
#  Link : https://programmers.co.kr/learn/courses/30/lessons/12933
def solution(n):
    answer = ''
    k = str(n)
    arr = []
    for i in k:
        arr.append(i)

    arr.sort()
    arr.reverse()

    for i in arr:
        answer = answer + str(i)

    return int(answer)