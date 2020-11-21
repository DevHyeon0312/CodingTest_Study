# Created By DevHyeon on 2020.11.21
#  Question Title : 핸드폰 번호 가리기
#  Algorithm Type : Implementation
#  Level : 1
#  Link : https://programmers.co.kr/learn/courses/30/lessons/12948
def solution(phone_number):
    answer = ''

    size = len(phone_number) - 4
    for i in phone_number[:size]:
        answer = answer + '*'

    for i in phone_number[size:]:
        answer = answer + i

    return answer