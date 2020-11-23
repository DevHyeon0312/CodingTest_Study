#  Created By DevHyeon on 2020.11.23
#  Question Title : 숫자 게임
#  Algorithm Type : Stack
#  Level : 3
#  Link : https://programmers.co.kr/learn/courses/30/lessons/12902
def solution(A, B):
    A.sort()
    B.sort()

    i = len(A) - 1
    A_point = 0
    B_point = 0
    while (i >= 0):
        if (A[i] >= B[i]):
            A.pop()
            B.pop(0)
            A_point = A_point + 1
        else:
            A.pop()
            B.pop()
            B_point = B_point + 1
        i = i - 1

    return B_point