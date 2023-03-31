n=int(input())
ans=0
for _ in range(n):
    word=input()
    is_true=0
    for i in range(len(word)-1):
        if word[i]!=word[i+1]:
            cur=word[i]
            for j in range(i+1,len(word)):
                if cur==word[j]:
                    is_true=1
                    break
            if is_true:
                break
    if not is_true:
        ans+=1
print(ans)