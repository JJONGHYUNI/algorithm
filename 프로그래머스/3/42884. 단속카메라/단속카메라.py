def solution(routes):
    answer = 0
    routes.sort()
    tmp = routes[0]
    for cur in routes[1:]:
        if cur[0] <= tmp[1]:
            tmp[1] = min(tmp[1], cur[1])
            continue
        
        answer += 1
        tmp = cur
    answer += 1
    return answer