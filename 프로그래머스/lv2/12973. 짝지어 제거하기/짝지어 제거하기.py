def solution(s):
    answer = 1
    stack=[]
    idx=0
    stack.append(s[idx])
    while True:
        idx+=1
        if idx>=len(s):
            break
        if stack and s[idx]==stack[-1]:
            stack.pop()
            continue
        stack.append(s[idx])
    if stack:
        answer=0
    else:
        answer=1
    return answer