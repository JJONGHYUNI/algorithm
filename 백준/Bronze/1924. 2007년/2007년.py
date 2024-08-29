import sys
input = sys.stdin.readline

x, y = map(int, input().split())
month = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
for i in range(x - 1):
    y += month[i]
d = ['SUN', 'MON', 'TUE', 'WED', 'THU', 'FRI', 'SAT']

print(d[(y%7)])