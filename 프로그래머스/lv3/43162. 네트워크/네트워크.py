def solution(n, computers):
    answer = 0
    visited=[0]*n
    for i in range(n):
        if not visited[i]:
            answer+=1
            dfs(i,visited,computers)
    return answer

def dfs(i,visited,computers):
    visited[i]=1
    for j in range(len(visited)):
        if i!=j and computers[i][j]:
            computers[i][j]=0
            dfs(j,visited,computers)