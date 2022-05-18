import sys
input=sys.stdin.readline

N,K=map(int,input().split())
#n!/(k!(n-k)!)
numerator=1
for i in range(1,N+1):
    numerator*=i
denominator=1
for i in range(1,K+1):
    denominator*=i
deno2=1
for i in range(1,N-K+1):
    deno2*=i
print(int(numerator/(denominator*deno2)))
