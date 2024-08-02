import sys
input = sys.stdin.readline

n = int(input())
ans = 0
if n < 100:
    ans = n
else:
    ans = 99
    for i in range(100, n + 1):
        tmp = list(map(int, str(i)))
        if tmp[0] - tmp[1] == tmp[1] - tmp[2]:
            ans += 1

print(ans)