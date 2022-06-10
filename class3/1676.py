import sys
input=sys.stdin.readline
def factorial(n):
    global answer
    if n==0:
        return 1
    else:
        return n*factorial(n-1)
n=int(input())
answer=str(factorial(n))
if len(answer)==1:
    print(0)
    exit()
for i in range(1,len(answer)):
    if answer[-i] !='0':
        print(i-1)
        break
