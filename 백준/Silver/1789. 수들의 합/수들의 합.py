import sys
input = sys.stdin.readline

s = int(input())
t = 0
cnt = 0

while True:
    cnt += 1
    t += cnt
    if t > s:
        break
print(cnt - 1)