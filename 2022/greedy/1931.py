import sys
input=sys.stdin.readline

N=int(input())
meet=[]

for i in range(N):
    start,end=map(int,input().split())
    meet.append([start,end])

meet.sort(key=lambda x:(x[1], x[0]))
answer=0
endtime=0
for i in range(len(meet)):
    if endtime<=meet[i][0]:
        endtime=meet[i][1]
        answer+=1

print(answer)
