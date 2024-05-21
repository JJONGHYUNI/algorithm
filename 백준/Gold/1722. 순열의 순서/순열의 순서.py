import sys
import math
input = sys.stdin.readline
n = int(input())
problem = list(map(int,input().split()))
case = [0] * n; case[0] = math.factorial(n)
for i in range(1,n):
  case[i] = case[i-1] // (n+1-i)
used = [False] * (n+1)

if problem[0] == 1:
  k = problem[1]
  find = [0] * (n)
  for i in range(n):
    for j in range(1,n+1):
        if not used[j]:
          if i+1 < n:
            if case[i+1] >= k:
              find[i] = j
              used[j] = True
              break
            else:
              k -= case[i+1]
          else:
            find[i] = j
  print(*find)
else:
  seq = problem[1:]
  order = 1
  idx = 1
  for i in seq:
    tmp = 0
    for j in range(1,n+1):
      if not used[j]:
        tmp += 1
        if i == j:
          break
    if idx < n:
      order += (tmp-1) * case[idx]
    idx += 1
    used[i] = True
  print(order)