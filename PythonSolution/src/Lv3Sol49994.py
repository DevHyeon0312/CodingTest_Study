#  Created By DevHyeon on 2020.11.23
#  Question Title : 방문 길이
#  Algorithm Type : Hash
#  Level : 3
#  Link : https://programmers.co.kr/learn/courses/30/lessons/49994
def solution(dirs):
    start = [0,0]
    hash = {}
    for i in dirs:
        if(i=="L"):
            if(start[0]-1 >= -5):
                startkey =  str(start[0]) + ',' + str(start[1])
                endkey = str(start[0] - 1) + ',' + str(start[1])
                start[0] = start[0] - 1
                start[1] = start[1]
                if((startkey+','+endkey in hash) or (endkey+','+startkey in hash) == False):
                    hash[startkey + ',' + endkey] = 0

        elif(i=="R"):
            if(start[0]+1 <= 5):
                startkey = str(start[0]) + ',' + str(start[1])
                endkey = str(start[0] + 1) + ',' + str(start[1])
                start[0] = start[0] + 1
                start[1] = start[1]
                if ((startkey + ',' + endkey in hash) or (endkey + ',' + startkey in hash) == False):
                    hash[startkey + ',' + endkey] = 0

        elif(i=="D"):
            if(start[1] - 1 >= -5):
                startkey = str(start[0]) + ',' + str(start[1])
                endkey = str(start[0]) + ',' + str(start[1] - 1)
                start[0] = start[0]
                start[1] = start[1] - 1
                if ((startkey + ',' + endkey in hash) or (endkey + ',' + startkey in hash) == False):
                    hash[startkey + ',' + endkey] = 0
        elif(i=="U"):
            if(start[1] + 1 <= 5):
                startkey = str(start[0]) + ',' + str(start[1])
                endkey = str(start[0]) + ',' + str(start[1] + 1)
                start[0] = start[0]
                start[1] = start[1] + 1
                if ((startkey + ',' + endkey in hash) or (endkey + ',' + startkey in hash) == False):
                    hash[startkey + ',' + endkey] = 0

    answer = len(hash.keys())


    return answer