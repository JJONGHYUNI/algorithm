import sys
input=sys.stdin.readline

def hanoi(n,start,to,end):
    if n==1:
        print(start,end)
    else:
        hanoi(n-1,start,end,to)
        print(start,end)
        hanoi(n-1,to,start,end)

N=int(input())
print(2**N-1)
hanoi(N,1,2,3)
