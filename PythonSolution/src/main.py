import Lv1Knumber

if __name__ == '__main__':
    Lv1KnumberResultArray = [1, 5, 2, 6, 3, 7, 4]
    Lv1KnumberResultCommands = [[2, 5, 3], [4, 4, 1], [1, 7, 3]]
    Lv1KnumberResult = Lv1Knumber.solution(Lv1KnumberResultArray,Lv1KnumberResultCommands)
    for i in Lv1KnumberResult :
        print(str(i), end=" " )