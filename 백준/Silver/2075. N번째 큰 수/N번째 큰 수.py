#start 18:54
#end   19:15

import sys
import heapq

input = sys.stdin.readline

n = int(input())
heap = []
for _ in range(n):
    a = list(map(int, input().split()))
    for i in a:
        if len(heap) == n:
            tmp = heapq.heappop(heap)
            if tmp < i:
                heapq.heappush(heap, i)
                continue
            heapq.heappush(heap, tmp)
            continue
        heapq.heappush(heap, i)

print(heap[0])
