from collections import deque
def solution(n, road, k):
    answer = 0
    dist=[500000*2000+1]*(n+1)
    dist[1]=0
    min_distance(dist,road)
    for i in dist:
        if i<=k:
            answer+=1
    return answer
    

def min_distance(dist,road):
    q=deque([1])
    while q:
        cur=q.popleft()
        for a,b,c in road:
            if a==cur or b==cur:
                node=a
                if a==cur:
                    node=b
                if dist[cur]+c<dist[node]:
                    dist[node]=dist[cur]+c
                    q.append(node)