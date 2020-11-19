# Created By DevHyeon on 2020.11.19
#  Question Title : 문자열 내림차순으로 배치하기
#  Algorithm Type : Sort
#  Level : 1
#  Link : https://programmers.co.kr/learn/courses/30/lessons/12917
def solution(s):
    answer = ''
    arr = []
    for i in s:
        arr.append(i)

    print(arr)
    arr.sort()
    arr.reverse()

    for i in arr:
        answer = answer + i
    return answer