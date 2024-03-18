def isEssense(n, s):
    tmp = s/n
    if (int(tmp) == tmp):
        return True
    return False

def solution(n, s):
    answer = []
    control = isEssense(n, s)
    tmp = int(s/n)
    if control:
        return [tmp for _ in range(n)]
    if tmp < 1:
        return [-1]
    rem = s - (tmp * n)
    for _ in range(n-rem):
        answer.append(tmp)
    for _ in range(rem):
        answer.append(tmp + 1)
    return answer