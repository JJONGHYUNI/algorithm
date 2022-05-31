import sys
input=sys.stdin.readline
N=int(input())
M=int(input())
if M!=0:
    fasil=list(input().split())
else:
    fasil=[]
answer=abs(N-100)
def remote():
    global answer
    for i in range(1000001):
        cur=str(i)
        for j in range(len(cur)):
            if cur[j] in fasil:
                break
            elif j==len(cur)-1:
                answer=min(answer,abs(int(cur)-N)+len(cur))
remote()
print(answer)
