
#
# Created By DevHyeon on 2020.11.18
#  Question Title : K번째 수
#  Algorithm Type : Sort
#  Level : 1
#  Link : https://programmers.co.kr/learn/courses/30/lessons/42748
#
def solution(array, commands):
    sarr = []

    print('=>', array)
    for i in commands:
        temp = array[i[0] - 1:i[1]]
        sarr.append(temp)

    answer = []
    index = 0
    for i in sarr:
        i.sort()
        answer.append(i[commands[index][2] - 1])
        index = index + 1

    return answer