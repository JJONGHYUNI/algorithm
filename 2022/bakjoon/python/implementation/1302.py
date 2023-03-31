import sys
input=sys.stdin.readline
n=int(input())
dic={}
for _ in range(n):
    book=input().strip()
    if book in dic.keys():
        dic[book]=dic[book]+1
    else:
        dic[book]=1
sdict=sorted(dic)
maxN=max(dic.values())
for i in sdict:
    if dic[i] == maxN:
        print(i)
        break
    else:
        continue
    
