import sys
input=sys.stdin.readline

word=list(input().strip())
i=0
start=0

while i<len(word):
    #괄호만나면
    if word[i]=="<":
        i+=1
        #괄호끝날때까지 변화없이 i증가
        while word[i]!='>':
            i+=1
        i+=1
    #문자나 숫자 만나면
    elif word[i].isalnum():
        #단어 시작점
        start=i
        #문자나 숫자가 끝나는부분까지 i증가
        while i<len(word) and word[i].isalnum():
            i+=1
        #단어 시작점 부터 끝까지 저장후 reverse로 뒤집음
        temp=word[start:i]
        temp.reverse()
        #뒤집힌 단어로 저장
        word[start:i]=temp
    #공백인 부분은 변화없이 i증가
    else:
        i+=1
print("".join(word))
