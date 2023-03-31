import sys
input=sys.stdin.readline
arr=set()
M=int(input())
for i in range(M):
    A=input().split()
    if len(A)==1:
        if A[0]=='all':
            arr=set([i for i in range(1,21)])
        else:
            arr.clear()
    else:
        a,b=A[0],int(A[1])
        if a=='add':
            arr.add(b)
        elif a=='remove':
            arr.discard(b)
        elif a=='check':
            print(1 if b in arr else 0)
        elif a=='toggle':
            if b in arr:
                arr.discard(b)
            else:
                arr.add(b)
        
