# Created By DevHyeon on 2020.11.19
#  Question Title : 문자열 내 마음대로 정렬하기
#  Algorithm Type : Sort
#  Level : 1
#  Link : https://programmers.co.kr/learn/courses/30/lessons/12915
def solution(strings, n):
    answer = []
    temp = []
    for i in strings:
        temp.append([i[n],i])

    temp.sort()
    for i in temp:
        answer.append(i[1])
    return answer