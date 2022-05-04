import sys
input=sys.stdin.readline

def star(n):
    if n==1:
        return ['*']
    n= n//3
    stars=star(n)
    upDown=[i*3 for i in stars]
    middle = [i + ' ' * n + i for i in stars]
    return upDown + middle + upDown
n= int(input())
userStar='\n'.join(star(n))
print(userStar)
