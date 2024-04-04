# start 17:25
# end   17:58
import sys
input = sys.stdin.readline

n = int(input())
s = []
ans = []
cnt = 1
for i in range(n):
    tmp = int(input())
    for j in range(cnt, tmp + 1):
        ans.append('+')
        cnt += 1
        s.append(j)
    if s[-1] == tmp:
        ans.append('-')
        s.pop()
    elif s[-1] > tmp:
        ans = []
        break
if ans:
    for i in ans:
        print(i)
else:
    print("NO")