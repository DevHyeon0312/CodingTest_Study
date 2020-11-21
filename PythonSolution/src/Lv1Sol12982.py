# Created By DevHyeon on 2020.11.21
#  Question Title : 예산
#  Algorithm Type : Implementation
#  Level : 1
#  Link : https://programmers.co.kr/learn/courses/30/lessons/12982
def solution(d, budget):
    answer = 0
    temp = 0
    d.sort()
    print(d)
    for i in d:
        if (temp + i <= budget):
            temp = temp + i
            answer = answer + 1
        else:
            return answer

    return answer