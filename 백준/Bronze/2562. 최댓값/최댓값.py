import sys
input = sys.stdin.readline

maxNum = -1
idx = 0
for i in range(1, 10):
    tmp = int(input())
    if (maxNum < tmp):
        maxNum = tmp
        idx = i
print(maxNum)
print(idx)