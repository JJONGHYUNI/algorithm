import sys
input=sys.stdin.readline
M=int(input())
N=int(input())
sosu=[]
for i in range(M,N+1):
    control=True
    if i>1:
        for j in range(2,i):
            if i%j==0:
                control=False
                break
        if control:
            sosu.append(i)
if sosu:
    print(sum(sosu))
    print(min(sosu))
else:
    print(-1)
    
