import sys
input=sys.stdin.readline
N,K=map(int,input().split())
words=list(input().strip() for _ in range(N))
realK=K-5
if K<5:
    print(0)
    exit(0)
elif K>=26:
    print(N)
    exit(0)
firstWord=['a','n','t','i','c']
word=['b','d','e','f','g','h','j','k','l','m','o','p','q','r','s','u','v','w','x','y','z']
visited=[0]*123
answer=[]
for i in firstWord:
    visited[ord(i)]=1
def brute(index):
    if index==realK:
        answer.append(isWord())
        return
    for i in word:
        if not visited[ord(i)]:
            visited[ord(i)]=1
            firstWord.append(i)
            print(firstWord)
            brute(index+1)
            visited[ord(i)]=0
            firstWord.pop()
        
def isWord():
    n=0
    control=True
    for i in range(N):
        for j in range(len(words[i])):
            if words[i][j] in firstWord:
                control=True
                continue
            else:
                control=False
                break
        if control:
            n+=1
    return n
brute(0)
print(max(answer))
