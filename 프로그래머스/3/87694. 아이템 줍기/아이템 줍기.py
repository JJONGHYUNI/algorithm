from collections import deque

def solution(rectangle, characterX, characterY, itemX, itemY):
    answer = 0
    
    board = [[-1] * 102 for _ in range(102)]
    for x1, y1, x2, y2 in rectangle :
        x1, y1, x2, y2 = x1 * 2, y1 * 2, x2 * 2, y2 * 2
        for i in range(x1, x2 + 1) :
            for j in range(y1, y2 + 1) :
                if x1 < i < x2 and y1 < j < y2 :
                    board[i][j] = 0
                elif board[i][j] != 0 :
                    board[i][j] = 1
    d = [0, 0, -1, 1]
    q = deque()
    q.append([characterX * 2, characterY * 2])
    
    visited = [[0] * 102 for _ in range(102)]
    visited[characterX * 2][characterY * 2] = 1
    
    itemX, itemY = itemX * 2, itemY * 2
    while q:
        x, y = q.popleft()
        
        if x == itemX and y == itemY:
            answer = visited[x][y] // 2
            break
        
        for i in range(4):
            dx = x + d[i]
            dy = y + d[3-i]
        
            if board[dx][dy] == 1 and not visited[dx][dy]:
                q.append(([dx, dy]))
                visited[dx][dy] = visited[x][y] + 1
    return answer