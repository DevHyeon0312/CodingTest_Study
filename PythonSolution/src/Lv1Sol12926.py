# Created By DevHyeon on 2020.11.21
#  Question Title : 시저 암호
#  Algorithm Type : Implementation
#  Level : 1
#  Link : https://programmers.co.kr/learn/courses/30/lessons/12926
def solution(s, n):
    answer = ''

    n = n%26

    for i in s:
        now = ord(i)
        if (now == 32):
            answer = answer + ' '
        else:
            temp = n
            if(now >= 65 and now <= 90):
                if(now + n > 90):
                    temp = n - (90-now)
                    now = 64
            if (now >= 97 and now <= 122):
                if (now + n > 122):
                    temp = n - (122 - now)
                    now = 96

            c = now + temp
            answer = answer + chr(c)

    return answer