
def solution(s):
    answer=0
    gualho="{[("
    for i in range(len(s)):
        s=s[1:]+s[0]
        stack=[]
        control=1
        for j in range(len(s)):
            if s[j] in gualho:
                stack.append(s[j])
            else:
                if stack and convert(stack.pop())==s[j]:
                    continue
                else:
                    control=0
                    break
        
        if control and not stack:
            answer+=1
    return answer

def convert(temp):
    if temp=='(':
        return ')'
    elif temp=='{':
        return '}'
    else:
        return ']'