import sys
input = sys.stdin.readline

n, k = map(int, input().split())
arr=[]

for i in range(1,n+1):
    if(n % i == 0):
        arr.append(i)

if(k <= len(arr)):
    print(arr[k-1])
else:
    print(0)