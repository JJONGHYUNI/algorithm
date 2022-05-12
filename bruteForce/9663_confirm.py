import sys
input=sys.stdin.readline

n=int(input())
board=[0]*(n)
answer=0
def n_queen(index):
    global answer
    if index==n:
        answer+=1
        print(board)
        return

    for i in range(n):
        board[index]=i
        if promising(index):
            n_queen(index+1)
        else:
            continue
def promising(current):
    for i in range(current):
        if board[current]==board[i] or abs(board[current]-board[i])==abs(current-i):
            return 0
    return 1

n_queen(0)
print(answer)
