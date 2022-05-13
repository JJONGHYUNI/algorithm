import sys
input=sys.stdin.readline

l,c=map(int,input().split())
wordList=list(input().split())
wordList.sort()
passWordList=[]
passWord=[]
vowels=['a','e','i','o','u']
consonants=['b','c','d','f','g','h','j','k','l','m','n','p','q','r','s','t','v','w','x','y','z']

def find_password(x,index):
    global passWord
    if index==l:
        current=''.join(passWord)
        passWord.sort()
        sortPassWord=''.join(passWord)
        if current==sortPassWord:
            if current not in passWordList:
                if promising(passWord):
                    passWordList.append(current)
                    return
        else:
            return

    for i in range(x,c):
        if wordList[i] not in passWord:
            passWord.append(wordList[i])
            find_password(i+1,index+1)
            passWord.pop()
        else:
            continue

def promising(current):
    vowel=0
    consonant=0
    for i in range(len(current)):
        if current[i] in vowels:
            vowel+=1
        elif current[i] in consonants:
            consonant+=1
    if vowel>0 and consonant>1:
        return 1
    else:
        return 0
find_password(0,0)
print('\n'.join(passWordList))
