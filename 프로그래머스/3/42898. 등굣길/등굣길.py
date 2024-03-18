def solution(m, n, puddles):
    answer = 0
    division = 1000000007
    board = [[1] * m for _ in range(n)]
    for x, y in puddles:
        board[y-1][x-1] = 0
        if y == 1:
            for i in range(x-1, m):
                board[y-1][i] = 0
            continue
        if x == 1:
            for i in range(y-1, n):
                board[i][x-1] = 0
    for y in range(1, n):
        for x in range(1, m):
            if not board[y][x]:
                continue
            board[y][x] = (board[y-1][x] + board[y][x-1]) % division
    answer = board[n-1][m-1]
    return answer