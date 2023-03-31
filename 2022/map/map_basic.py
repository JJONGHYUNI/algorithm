#9375
import sys
input=sys.stdin.readline
n=int(input())
for i in range(3):
    k=int(input())
    map ={}
    answer=1
    for j in range(k):
        a,b = input().split()
        if not b in map:
            map[b]=1
        else:
            map[b]+=1
    for k in map.keys():
        answer*=(map[k]+1)
    print(answer-1)
    
