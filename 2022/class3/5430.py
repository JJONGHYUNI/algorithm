import sys
from collections import deque
input=sys.stdin.readline
def ac():
    rCount=0
    for i in range (len(command)):
        if command[i] =='R':
            rCount+=1
        elif command[i] =='D':
            rCount%=2
            if q:
                if rCount==1:
                    q.pop()
                else:
                    q.popleft()
            else:
                print("error")
                return

    rCount%=2
    if rCount==1:
        q.reverse()
    print('['+','.join(q)+']')

T=int(input())
for _ in range(T):
    command=input().rstrip()
    N=int(input())
    array=input().rstrip()[1:-1].split(",")
    q=deque(array)
    if N==0:
        q=deque()
    ac()
