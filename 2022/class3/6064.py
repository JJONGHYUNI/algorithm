import sys
input=sys.stdin.readline

def kaing(distance):
    cur=x
    while cur<=distance:
        if cur%N==y%N:
            print(cur)
            return
        else:
            cur+=M
    print(-1)
def GCD(x,y):
    while(y):
        x,y=y,x%y
    return x
def LCM(x,y):
    result=(x*y)//GCD(x,y)
    return result

T=int(input())

for _ in range(T):
    M,N,x,y=map(int,input().split())
    idx=LCM(M,N)
    kaing(idx)
