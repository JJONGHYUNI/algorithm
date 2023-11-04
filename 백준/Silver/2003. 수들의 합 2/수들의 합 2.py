import sys
input = sys.stdin.readline

n,m = map(int,input().split())
answer = 0
board = list(map(int,input().split()))
for i in range(n):
    tmp = board[i]
    if tmp == m :
        answer +=1
        continue
    elif tmp > m :
        continue
    for j in range(i+1, n):
        tmp += board[j]
        if(tmp == m) :
            answer += 1
            break
        elif(tmp > m):
            break
print(answer)
