import sys
input=sys.stdin.readline
N=int(input())
sosuList=[]
answerList=[]
answer=0
def prime(n):
    isPrime=[True]*(n+1)
    for i in range(2,n+1):
        if isPrime[i]==True:
            j=2
            sosuList.append(i)
            while i*j<=n:
                isPrime[i*j]=False
                j+=1
prime(N)
def sumSosu(x):
    global answerList
    global answer
    if sum(answerList)==N:
        answer+=1
        return
    elif sum(answerList)>N:
        return
    if x>=len(sosuList):
        return
    answerList.append(sosuList[x])
    sumSosu(x+1)
    answerList.pop()
for i in range(len(sosuList)):
    sumSosu(i)
print(answer)
