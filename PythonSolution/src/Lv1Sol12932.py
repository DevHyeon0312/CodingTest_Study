# Created By DevHyeon on 2020.11.21
#  Question Title : 자연수 뒤집어 배열로 만들기
#  Algorithm Type : Implementation
#  Level : 1
#  Link : https://programmers.co.kr/learn/courses/30/lessons/12932
def solution(n):
    answer = []
    k = str(n)
    for i in k:
        answer.append(int(i))

    answer.reverse()

    return answer