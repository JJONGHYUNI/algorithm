import sys
input = sys.stdin.readline

a, b, c, d, e = map(int, input().split())
ans = (a * a + b * b + c * c + d * d + e * e) % 10
print(ans)