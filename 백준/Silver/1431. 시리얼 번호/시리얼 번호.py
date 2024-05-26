import sys

input = sys.stdin.readline

def Sum(nums):
    result = 0
    for i in nums:
        if i.isdigit():
            result += int(i)
    return result

n = int(input())
serial = [input().rstrip() for _ in range(n)]

serial.sort(key = lambda x:(len(x), Sum(x), x))

for i in serial:
    print(i)
