import math

def solution(n, stations, w):
    answer = 0
    pre = 1
    for station in stations:
        tmp = station - pre - w
        if tmp > 0:
            answer += math.ceil(tmp / ((w * 2) + 1))
        pre = station + w + 1
    tmp = n - pre + 1
    if tmp > 0:
        answer += math.ceil(tmp / ((w * 2) + 1))
    return answer