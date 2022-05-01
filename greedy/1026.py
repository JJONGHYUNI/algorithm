import sys
input=sys.stdin.readline

n=int(input())

a=list(map(int,input().split()))
b=list(map(int,input().split()))

a.sort()
b.sort(reverse=True)

answer=[]
for i in range(n):
    mul=a[i]*b[i]
    answer.append(mul)
print(sum(answer))
