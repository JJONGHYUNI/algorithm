# start 16:56
# end   17:58
import sys
from collections import deque
input = sys.stdin.readline

s = list(input().strip())
m = int(input())
n = len(s)
right = deque()
for _ in range(m):
    c = list(input().split())
    if c[0] == 'L' and s:
        right.insert(0, s.pop())
    elif c[0] == 'D' and right:
        s.append(right.popleft())
    elif c[0] == 'B' and s:
        s.pop()
    if c[0] == 'P':
        s.append(c[1])
print("".join(s) + "".join(right))