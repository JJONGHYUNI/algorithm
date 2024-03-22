import sys
input=sys.stdin.readline
sys.setrecursionlimit(10**6)

n=int(input())
#트리 생성
tree=[[] for _ in range(n+1)]

#index부터 각 노드의 거리 구하기
def find(index,weight):
    for i in tree[index]:
        a,b=i
        if distance[a]==-1:
            distance[a]=weight+b
            find(a,weight+b)
for _ in range(n-1):
    a,b,c=map(int,input().split())
    tree[a].append([b,c])
    tree[b].append([a,c])

#거리를 담을 변수 default:-1 << -1이면 아직 구하지 못한 곳
distance = [-1]*(n+1)
distance[1]=0
#1에서 부터의 거리를 구함
find(1,0)

#1에서 부터 가장 먼 거리의 인덱스에서 다시 제일 먼곳을 구하기
answer_index=distance.index(max(distance))
distance=[-1]*(n+1)
distance[answer_index]=0
find(answer_index,0)

print(max(distance))
