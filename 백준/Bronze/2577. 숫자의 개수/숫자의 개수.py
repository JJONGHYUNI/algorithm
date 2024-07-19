import sys
input = sys.stdin.readline

a = int(input())
b = int(input())
c = int(input())

abc = a*b*c

dic = {}

for i in range(10):
    dic[i] = 0

while abc != 0:
    dic[abc%10] += 1
    abc //= 10

for i in range(10):
    print(dic[i])
