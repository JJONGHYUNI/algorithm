import sys
input = sys.stdin.readline

s = input()
alpha = 'abcdefghijklmnopqrstuvwxyz'

for i in alpha:
    print(s.find(i), end = ' ')
