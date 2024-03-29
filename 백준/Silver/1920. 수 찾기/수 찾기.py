#start 17:12
#end   17:28

import sys
input = sys.stdin.readline

n = int(input())
arr = list(map(int,input().split()))
m = int(input())
m = list(map(int,input().split()))
arr.sort()
for tmp in m:
    l, r = 0, n - 1
    control = 0

    while l <= r:
        aver = (l + r) // 2
        if tmp == arr[aver]:
            control = 1
            print(1)
            break
        if tmp > arr[aver]:
            l = aver + 1
            continue
        r = aver - 1

    if not control:
        print(0)
