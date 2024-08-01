import sys
input = sys.stdin.readline

c = int(input())
for _ in range(c):
    arr = list(map(int, input().split()))
    n = arr[0]
    average = sum(arr[1:]) / n
    ans = 0
    for i in arr[1:]:
        if i > average:
            ans += 1
    ans = ans / n * 100
    print(f'{ans:.3f}%')
