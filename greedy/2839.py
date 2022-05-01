import sys
input= sys.stdin.readline
n=int(input())

if n==4 or n ==7:
    print(-1)
elif n%5==0:
    print(n//5)
elif n%5==1 or n%5 ==3:
    print(n//5+1)
else:
    print(n//5+2)
