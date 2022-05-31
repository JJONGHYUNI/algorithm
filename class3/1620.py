import sys
input=sys.stdin.readline

N,M=map(int,input().split())
dictionary={}
for i in range(1,N+1):
    word=input().rstrip()
    dictionary[word]=i
    dictionary[i]=word
for i in range(M):
    word=input().rstrip()
    if word.isdigit():
        print(dictionary[int(word)])
    else:
        print(dictionary[word])
