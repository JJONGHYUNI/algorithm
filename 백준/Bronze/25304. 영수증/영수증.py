import sys
input = sys.stdin.readline

x = int(input())
n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]

price = 0

for a, b in arr:
    price += a * b

if price == x:
    print("Yes")
else:
    print("No")
    
