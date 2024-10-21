import sys
input = sys.stdin.readline

words = [input().strip() for _ in range(5)]
s = ''
for i in range(15):
    for j in range(5):
        if len(words[j]) <= i:
            continue
        s += words[j][i]

print(s)