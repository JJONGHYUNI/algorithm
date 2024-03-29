#start 17:30
#end   17:50

import sys
input = sys.stdin.readline

k, n = map(int,input().split())

arr = []

for _ in range(k):
    arr.append(int(input()))

l, r = 1, max(arr)

while l <= r:
    aver = (l + r) // 2
    lan = 0
    for i in arr:
        lan += i // aver
    if lan >= n:
        l = aver + 1
        continue
    r = aver - 1
print(r)
