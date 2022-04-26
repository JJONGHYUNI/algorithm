import sys
input=sys.stdin.readline
sys.setrecursionlimit(10**9)
V=int(input())
tree=[[] for _ in range(V+1)]
def find(index,answer):
    for i in tree[index]:
        a,b=i
        if distance[a]==-1:
            distance[a]=answer+b
            find(a,answer+b)
for _ in range(V):
    arr = list(map(int, input().split()))
    for i in range(1, len(arr)-1, 2):
        tree[arr[0]].append((arr[i], arr[i+1]))
    
distance=[-1]*(V+1)
distance[1]=0
find(1,0)

answer_index=distance.index(max(distance))
distance=[-1]*(V+1)
distance[answer_index]=0
find(answer_index,0)
print(max(distance))
