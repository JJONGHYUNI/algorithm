import sys
input=sys.stdin.readline

n=int(input())
array=list(map(int,input().split()))
calArray=list(map(int,input().split()))
answer=[]
def backTraking(index,sum):
    global answer
    if index==n-1:
        answer.append(sum)
        return
    for i in range(4):
        current=sum
        if calArray[i]==0:
            continue
        if i==0:
            sum+=array[index+1]
        elif i==1:
            sum-=array[index+1]
        elif i==2:
            sum*=array[index+1]
        else:
            if sum<0:
                sum=abs(sum)//array[index+1]*-1
            else:
                sum//=array[index+1]
        calArray[i]-=1
        backTraking(index+1,sum)
        calArray[i]+=1
        sum=current
backTraking(0,array[0])
print(max(answer))
print(min(answer))


