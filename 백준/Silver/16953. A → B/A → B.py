# start 19:20
# end   19:33

import sys
from collections import deque
input = sys.stdin.readline

a, b = map(int, input().split())
q = deque()
q.append((a,0))

while q:
    tmp, cnt = q.popleft()
    if tmp == b:
        print(cnt + 1)
        exit()
    for i in range(2):
        if i == 0:
            if tmp * 2 > b:
                continue
            q.append((tmp * 2, cnt+1))
            
        temp = int(str(tmp) + '1')
        if temp > b:
            continue
        q.append((temp, cnt+1))
print(-1)
