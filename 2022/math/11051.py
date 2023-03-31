import sys
input=sys.stdin.readline

N,K=map(int,input().split())
numerator=1
for i in range(1,N+1):
    numerator*=i
denominator=1
for i in range(1,K+1):
    denominator*=i
deno2=1
for i in range(1,N-K+1):
    deno2*=i
print(numerator//(denominator*deno2)%10007)
print(numerator)
