import sys
input=sys.stdin.readline

n=int(input())
time=list(map(int,input().split()))

time.sort()
answer=0
for i in range(n):
    for j in range(i+1):
        answer+=time[j]
print(answer)
