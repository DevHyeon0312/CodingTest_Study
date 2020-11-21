# Created By DevHyeon on 2020.11.21
#  Question Title : 직사각형 별찍기
#  Algorithm Type : Implementation
#  Level : 1
#  Link : https://programmers.co.kr/learn/courses/30/lessons/12969
a, b = map(int, input().strip().split(' '))

for i in range(b):
    t = ''
    for j in range(a):
        t=t+'*'
    print(t)