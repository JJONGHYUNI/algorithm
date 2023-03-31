import sys
input=sys.stdin.readline

n=int(input())
rope=[]
for _ in range(n):
    ropeData=int(input())
    rope.append(ropeData)
index=1
rope.sort(reverse=True)
answer=[]
while len(rope):
    answer.append(len(rope)*rope.pop())

print(max(answer))
