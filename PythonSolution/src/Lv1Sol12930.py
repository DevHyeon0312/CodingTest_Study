# Created By DevHyeon on 2020.11.21
#  Question Title : 이상한 문자 만들기
#  Algorithm Type : Implementation
#  Level : 1
#  Link : https://programmers.co.kr/learn/courses/30/lessons/12930
def solution(s):
    answer = ''

    witch = 0
    for i in s:
        if(i == ' '):
            answer = answer + ' '
            witch = 0
        else:
            if(witch == 0):
                answer = answer + i.upper()
                witch = 1
            else:
                answer = answer + i.lower()
                witch = 0

    return answer