n = int(input())

for i in range(n):
    a = input()
    point = 0
    ans = 0
    for j in a:
        if j == 'O':
            point += 1
        else:
            point = 0
        ans += point
    print(ans)
