import sys
input=sys.stdin.readline

N=int(input())
idx=1
cnt=1
while N>idx:
    idx+=6*cnt
    cnt+=1
print(cnt)
