# Created By DevHyeon on 2020.11.21
#  Question Title : 제일 작은 수 제거하기
#  Algorithm Type : Implementation
#  Level : 1
#  Link : https://programmers.co.kr/learn/courses/30/lessons/12935
def solution(arr):
    answer = []
    temp = arr[:]

    temp.sort()
    arr.remove(temp[0])

    if (arr == []):
        answer.append(-1)
        return answer

    return arr