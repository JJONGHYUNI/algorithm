#2164
from collections import deque
n=int(input())

queue=deque([])
for i in range(n):
    queue.append(i)

while len(queue)>1:
    queue.popleft()
    num=queue.popleft()
    queue.append(num)
print(queue.popleft()+1)
