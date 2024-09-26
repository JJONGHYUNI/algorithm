import sys
input = sys.stdin.readline

n, b = map(int, input().split())
formatter = '0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ'
s = ''

while n:
    s += formatter[n % b]
    n //= b
print(s[::-1])