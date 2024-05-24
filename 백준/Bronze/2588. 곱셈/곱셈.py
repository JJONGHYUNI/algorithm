import sys

input = sys.stdin.readline
n = int(input())
n2 = int(input())

a = n * (n2 % 10)
b = n * (n2 % 100 // 10)
c = n * (n2 // 100)

print(a)
print(b)
print(c)
print(n * n2)