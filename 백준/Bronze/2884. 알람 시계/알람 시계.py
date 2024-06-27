import sys
input = sys.stdin.readline

h, m = map(int, input().split())

mm = m - 45
if mm < 0 :
    mm += 60
    h -= 1
    if (h < 0) :
        h += 24

print(h, mm)