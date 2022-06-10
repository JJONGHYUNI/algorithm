import sys
input=sys.stdin.readline

N,M=map(int,input().split())
Dict={}
answer=[]
for _ in range(N):
    Dict[input().rstrip()]=0
for _ in range(M):
    key=input().rstrip()
    if key in Dict:
        answer.append(key)
    else:
        continue
answer.sort()
print(len(answer))
print('\n'.join(answer))
