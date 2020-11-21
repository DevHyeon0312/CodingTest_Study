# Created By DevHyeon on 2020.11.19
#  Question Title : 문자열 다루기 기본
#  Algorithm Type : Implementation
#  Level : 1
#  Link : https://programmers.co.kr/learn/courses/30/lessons/12918
def solution(s):
    answer = True
    if len(s) != 6 and len(s) != 4:
        answer = False
    try:
        int(s)
    except ValueError:
        answer = False
    return answer