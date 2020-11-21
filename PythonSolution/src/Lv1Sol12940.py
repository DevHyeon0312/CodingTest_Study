# Created By DevHyeon on 2020.11.21
#  Question Title : 최대공약수와 최소공배수
#  Algorithm Type : Implementation
#  Level : 1
#  Link : https://programmers.co.kr/learn/courses/30/lessons/12940
def solution(n, m):
    answer = []

    g = gcd(n, m)
    answer.append(g)
    g2 = int(n * m / g)
    answer.append(g2)

    return answer


def gcd(a, b):
    if (b == 0):
        return a
    else:
        return gcd(b, a % b)