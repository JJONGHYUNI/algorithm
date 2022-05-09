import sys
input=sys.stdin.readline

n,r,c=map(int,input().split())
count=0
def zSearch(y,x,n):
    global count
    if y>r or y+n<=r or x>c or x+n<=c:
        count+= n**2
        return
    if n==2:
        if (r==y or r==y+1) and (c==x or c==x+1):
            if r==y and c==x:
                print(count)
            elif r==y+1 and c==x:
                print(count+2)
            elif r==y and c==x+1:
                print(count+1)
            elif r==y+1 and c==x+1:
                print(count+3)
        sys.exit(0)
    else:
        zSearch(y,x,n//2)
        zSearch(y,x+n//2,n//2)
        zSearch(y+n//2,x,n//2)
        zSearch(y+n//2,x+n//2,n//2)
        return
zSearch(0,0,2**n)
print(count)
