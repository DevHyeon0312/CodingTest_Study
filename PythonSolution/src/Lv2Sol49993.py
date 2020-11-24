#  Created By DevHyeon on 2020.11.25
#  Question Title : 스킬트리
#  Algorithm Type : Implementation
#  Level : 2
#  Link : https://programmers.co.kr/learn/courses/30/lessons/49993
def solution(skill, skill_trees):
    answer = 0

    for i in skill_trees:
        bool = True
        type = 0
        ind = 0
        # print(i)
        for j in skill:
            try:
                # print(i.index(j))
                if (i.index(j) >= ind and type == 0):
                    ind = i.index(j)


                else:
                    bool = False
            except ValueError as e:
                type = 1
                # print(e)

        # print(bool)
        if (bool == True):
            answer = answer + 1
            # print('=',answer)
    return answer