#  Created By DevHyeon on 2020.11.24
#  Question Title : 정수 삼각형
#  Algorithm Type : DP
#  Level : 3
#  Link : https://programmers.co.kr/learn/courses/30/lessons/43105

import copy
def solution(triangle):
    tri = copy.copy(triangle)
    dp = []

    for i in range(len(triangle)):
        dp.append(copy.copy(tri[i]))
        if(i!=0):
            for j in range(i):
                temp = (tri[i][j] + tri[i - 1][j])
                if (dp[i][j] < temp):
                    dp[i][j] = temp
                temp = (tri[i][j + 1] + tri[i - 1][j])
                if (dp[i][j + 1] < temp):
                    dp[i][j + 1] = temp
            tri[i] = dp[i]


    ans = dp[len(dp)-1]
    ans.sort()
    answer = ans.pop()
    return answer