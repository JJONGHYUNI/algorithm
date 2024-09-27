import sys
input = sys.stdin.readline

n = int(input())

while n != -1:
    arr = []
    arr.append(1)
    for i in range(2, int(n ** 0.5) + 1):
        if n % i == 0:
            arr.append(i)
            arr.append(n // i)
    if sum(arr) != n:
        print(n, "is NOT perfect.")
        n= int(input())
        continue
    
    arr.sort()
    print(n, "=", " + ".join(map(str, arr)))
        
    n = int(input())