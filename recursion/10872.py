import sys
input=sys.stdin.readline

def factorial(n):
    if n>1:
        return n*factorial(n-1)
    else:
        return 1
N=int(input())
answer=factorial(N)
print(answer)
