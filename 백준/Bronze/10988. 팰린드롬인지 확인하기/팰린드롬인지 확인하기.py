import sys
input = sys.stdin.readline

s = list(input().strip())

if s[::-1] == s:
  print(1)
else:
  print(0)