import sys
input = sys.stdin.readline

dials = ['ABC', 'DEF', 'GHI', 'JKL', 'MNO', 'PQRS', 'TUV', 'WXYZ']
s = input()
ans = 0

for tmp in s:
    for i in range(8):
        if tmp in dials[i]:
            ans += i + 3

print(ans)