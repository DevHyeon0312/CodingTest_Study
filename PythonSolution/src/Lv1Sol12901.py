# Created By DevHyeon on 2020.11.19
#  Question Title : 2016년
#  Algorithm Type : Implementation
#  Level : 1
#  Link : https://programmers.co.kr/learn/courses/30/lessons/12901
import datetime
def solution(a, b):
    day = ['MON','TUE','WED','THU','FRI','SAT','SUN']
    return day[datetime.date(2016,a,b).weekday()]