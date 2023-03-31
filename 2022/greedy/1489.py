import sys
input=sys.stdin.readline

n=int(input())
A=list(map(int,input().split()))
B=list(map(int,input().split()))

csortA=[0 for _ in range(1002)]
csortB=[0 for _ in range(1002)]

for i in range(n):
    csortA[A[i]] +=1
for i in range(n):
    csortB[B[i]] +=1

answer=0

for i in range(len(csortA)-1):
    while csortA[i]:
        control=False
        for j in range(i-1,0,-1):
            if csortB[j]:
                control=True
                csortA[i]-=1
                csortB[j]-=1
                answer+=2
                break
        if control==False:
            break

for i in range(len(csortA)-1):
    while csortA[i] and csortB[i]:
        csortA[i]-=1
        csortB[i]-=1
        answer+=1

print(answer)
