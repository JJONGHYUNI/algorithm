#start 18:54
#end   19:20

import sys
import heapq

input = sys.stdin.readline

n = int(input())
heap = []
for _ in range(n):
    a = list(map(int, input().split()))
    for i in a:
        if len(heap) == n:
            if heap[0] < i:
                heapq.heappop(heap)
                heapq.heappush(heap, i)
                continue
            continue
        heapq.heappush(heap, i)

print(heap[0])
