import sys
input=sys.stdin.readline

cal=input().split('-')

answer=0

for i in cal[0].split('+'):
    answer+=int(i)

for i in cal[1:]:
    for j in i.split('+'):
        answer-=int(j)
print(answer)
