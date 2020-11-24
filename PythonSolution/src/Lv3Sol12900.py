#  Created By DevHyeon on 2020.11.24
#  Question Title : 2 x n 타일링
#  Algorithm Type : Implementation
#  Level : 3
#  Link : https://programmers.co.kr/learn/courses/30/lessons/12900
def solution(n):
    dp = [0]*(n+1)
    dp[1] = 1
    for i in range(2,n+1):
        dp[i] = (dp[i-2]+dp[i-1])%1000000007

    return (dp[i-1]+dp[i])%1000000007