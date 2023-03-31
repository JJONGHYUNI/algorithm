#2812
n,k=map(int,input().split())
number=list(input())
count=0
answer=[]
for num in number:
    while answer and count!=k and answer[-1]<num:
        del answer[-1]
        count+=1
    answer.append(num)
for i in range(n-k):
    print(answer[i],end="")
