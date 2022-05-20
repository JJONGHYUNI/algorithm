import sys
input=sys.stdin.readline
def LCM(a,b):
    return (a*b)

def GCD(a,b):
    if b%a:
        return GCD(b%a,a)
    else: return a
T=int(input())
for _ in range(T):
    a,b=map(int,input().split())
    print(LCM(a,b)//GCD(a,b))
