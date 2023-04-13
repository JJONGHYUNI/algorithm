d=[(1,0),(0,1),(1,1)]
m,n=0,0
def solution(row, col, board):
    answer=0
    global m,n
    m=row
    n=col
    board=[list(board[i]) for i in range(row)]
    while True:
        board,cnt=check(board)
        if not cnt:
            break
        board=move(board)
        answer+=cnt
    
    
    return answer

def check(board):
    checkBoard=[[0]*n for i in range(m)]
    for i in range(m-1):
        for j in range(n-1):
            if board[i][j]:
                tmp,control=board[i][j],1
                for c,r in d:
                    if board[i+r][j+c]!=tmp:
                        control=0
                if control:
                    checkBoard[i][j]=1
                    for c,r in d:
                        checkBoard[i+r][j+c]=1
    cnt=0
    for i in checkBoard:
        cnt+=i.count(1)
    if cnt:
        clear(board,checkBoard)
        return board,cnt
    return board,cnt
def clear(board,checkBoard):
    for i in range(m):
        for j in range(n):
            if checkBoard[i][j]:
                board[i][j]=0
    return board

def move(board):
    for i in range(m-1,-1,-1):
        for j in range(n-1,-1,-1):
            if board[i][j]:
                idx=i
                while True:
                    if idx+1>=m:
                        break
                    if not board[idx+1][j]:
                        board[idx+1][j],board[idx][j]=board[idx][j],0
                    else: break
                    idx+=1
    return board