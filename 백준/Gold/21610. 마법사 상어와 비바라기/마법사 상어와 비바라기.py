# start 17:47
# end   18:55
import sys
input = sys.stdin.readline

n, m = map(int, input().split())

a = [list(map(int, input().split())) for _ in range(n)]
s = [list(map(int, input().split())) for _ in range(m)]
cloud = [(n-1, 0), (n-1, 1), (n-2, 0), (n-2, 1)]

d = [(0, -1), (-1, -1), (-1, 0), (-1, 1), (0, 1), (1, 1), (1, 0), (1, -1)]

def move_idx(direction, distance):
    newCloud = set()
    while cloud:
        i,j = cloud.pop()
        dy, dx = (i + (d[direction][0] * distance)) % n, (j + (d[direction][1] * distance)) % n
        a[dy][dx] += 1
        newCloud.add((dy,dx))
    
    return newCloud

def skill(newCloud):
    for i, j in newCloud:
        cnt = 0
        for k in range(1, 8, 2):
            dy = i + d[k][0]
            dx = j + d[k][1]
            if 0 <= dy <n and 0 <= dx < n:
                if a[dy][dx]:
                    cnt +=1
        a[i][j] += cnt
                

def make_cloud(newCloud):
    newCloud2 = set()
    for i in range(n):
        for j in range(n):
            if (i, j) not in newCloud:
                if a[i][j] >= 2:
                    a[i][j] -= 2
                    newCloud2.add((i, j))
                continue
    return newCloud2
    

for direction, distance in s:
    newCloud = move_idx(direction - 1, distance)
    skill(newCloud)
    cloud = make_cloud(newCloud)
answer = 0
for i in a:
    answer += sum(i)
print(answer)