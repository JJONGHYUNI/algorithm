import sys
input = sys.stdin.readline

n = int(input())

isPrime = [1] * 1001

def find_prime():
    isPrime[0] = 0
    isPrime[1] = 0
    
    for i in range(2, 100):
        if isPrime[i]:
            for j in range(i + i, 1001, i):
                isPrime[j] = 0
find_prime()
arr = list(map(int, input().split()))
ans = 0
for i in arr:
    if isPrime[i]:
        ans += 1
print(ans)
