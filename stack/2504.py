import sys
input=sys.stdin.readline

stack=[]
array=list(input().strip())
answer=0
for i in array:
    if i ==')':
        temp=0
        while stack:
            if '(' not in stack:
                print(0)
                exit(0)
            current=stack.pop()
            if current=='(':
                if temp==0:
                    stack.append(2)
                else:
                    stack.append(2*temp)
                break
            elif current=='[':
                print(0)
                exit(0)
            else:
                temp=temp+int(current)
    elif i==']':
        if '[' not in stack:
                print(0)
                exit(0)
        temp=0
        while stack:
            current=stack.pop()
            if current=='[':
                if temp==0:
                    stack.append(3)
                else:
                    stack.append(3*temp)
                break
            elif current=='(':
                print(0)
                exit(0)
            else:
                temp=temp+int(current)
    else:
        stack.append(i)
List=['(','[',')',']']
for i in stack:
    if i in List:
        answer=0
        break
    else:
        answer+=i
        
print(answer)
