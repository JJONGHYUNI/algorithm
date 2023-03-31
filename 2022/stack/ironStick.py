#10799
import sys
razor=input()
answer=0
index=0
for i in range(len(razor)):
    if razor[i]=="(":
        index+=1
        if razor[i+1]==")":
            index-=1
            answer+=index
    elif razor[i]==")"and razor[i-1]==")":
        index-=1
        answer+=1
print(answer)
