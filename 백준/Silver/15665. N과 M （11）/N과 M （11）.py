# start 13:58
# end   14:15
import sys
sys.setrecursionlimit(10 ** 6)

input = sys.stdin.readline

n, m = map(int, input().split())
nums = list(map(int, input().split()))

nums = sorted(set(nums))

def dfs(num):
    if len(num) == m:
        print(" ".join(map(str,num)))
        return
    for j in nums:
        num.append(j)
        dfs(num)
        num.pop()

dfs([])