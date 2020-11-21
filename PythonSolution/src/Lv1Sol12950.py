# Created By DevHyeon on 2020.11.21
#  Question Title : 행렬의 덧셈
#  Algorithm Type : Implementation
#  Level : 1
#  Link : https://programmers.co.kr/learn/courses/30/lessons/12950
def solution(arr1, arr2):
    answer = []
    column = len(arr1[0]) #행의 개수 (가로)
    row = len(arr1) #열의 개수 (세로)
    for i in range(row):
        temp = []
        for j in range(column):
            a = arr1[i][j]+arr2[i][j]
            temp.append(a)
        answer.append(temp)

    return answer