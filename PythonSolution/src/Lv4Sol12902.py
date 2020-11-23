#  Created By DevHyeon on 2020.11.23
#  Question Title : 3 x n 타일링
#  Algorithm Type : Implementation
#  Level : 4
#  Link : https://programmers.co.kr/learn/courses/30/lessons/12902
def solution(n):
    answer= 0
    if(n==0):
        return 1
    elif(n==1):
        return 0
    elif(n==2):
        return 3
    array = [0] * (n+1)
    array[0] = 1
    array[1] = 0
    array[2] = 3

    i = 3
    yh = 1
    while(i<=n):
        if(i%2==1):
            array[i] = 0
        else:
            array[i] = ((3 * array[i-2]) + (yh*2))
            yh = yh + array[i-2]
        i = i+1
    answer = array[n]%1000000007
    return answer