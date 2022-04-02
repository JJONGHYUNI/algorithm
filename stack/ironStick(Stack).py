#10799
import sys
razor=input()
answer=0
index=[]
for i in range(len(razor)):
    if razor[i]=="(":
        index.append(razor[i])
        if razor[i+1]==")":
            index.pop()
            answer+=len(index)
    elif razor[i]==")"and razor[i-1]==")":
        index.pop()
        answer+=1
print(answer)
