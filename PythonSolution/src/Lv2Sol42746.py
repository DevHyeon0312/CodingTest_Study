#  Created By DevHyeon on 2020.11.25
#  Question Title : 가장 큰 수
#  Algorithm Type : Sort
#  Level : 2
#  Link : https://programmers.co.kr/learn/courses/30/lessons/42746
def solution(numbers):
    arr = []

    for i in numbers:
        i = str(i)
        temp = i
        if (len(i) != 4):
            for j in range(4 - len(i)):
                i = i + i[j]
            arr.append([int(i), temp])
        else:
            arr.append([int(i), temp])

    arr.sort()
    arr.reverse()

    answer = ''
    for i in arr:
        answer = answer + i[1]
        if (answer[0] == '0'):
            return answer[0]

    return answer