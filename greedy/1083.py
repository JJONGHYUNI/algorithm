import sys
input=sys.stdin.readline

N=int(input())
num=[int(i) for i in input().split()]
S=int(input())
while True:
    control=False
    for i in range(N):
        count=0
        index=i
        for j in range(i,N):
            if num[index]<num[j] and j-i<=S:
                index=j
                control=True
                count=j-i
        if(index!=i):
            change=num[index]
            del num[index]
            num.insert(i,change)
            S-=count
            break
    if control==False:
        break
for i in range(N):
    print(num[i],end=' ')
    

