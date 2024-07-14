import sys
input = sys.stdin.readline

a, b = map(int, input().split())
c = int(input())

hour = c // 60
minute = c % 60

hour += a
minute += b
if minute >= 60:
    minute -= 60
    hour += 1
if hour >= 24:
    hour -= 24
print(hour, minute)
