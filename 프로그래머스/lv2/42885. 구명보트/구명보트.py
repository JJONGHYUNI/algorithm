def solution(people, limit):
    answer = 0
    people.sort()
    idx=0
    while True:
        if idx>=len(people):
            break
        if people[idx]+people.pop()<=limit:
            answer+=1
            idx+=1
            continue
        else:
            answer+=1
            continue
        
    return answer