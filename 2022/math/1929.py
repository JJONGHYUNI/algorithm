import sys
input=sys.stdin.readline

M,N=map(int,input().split())
sosu=[]
def prime(n):
    isPrime=[True]*(n+1)
    for i in range(2,n+1):
        if isPrime[i]==True:
            j=2
            if i>=M:
                sosu.append(i)
            while i*j<=n:
                isPrime[i*j]=False
                j+=1
prime(N)
print('\n'.join(map(str,sosu)))
