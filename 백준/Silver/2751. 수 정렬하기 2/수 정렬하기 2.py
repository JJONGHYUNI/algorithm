# start 16:29
# end   16:31
import sys

input = sys.stdin.readline

n = int(input())
arr = []
for _ in range(n):
    arr.append(int(input()))

arr.sort()

for i in arr:
    print(i)
