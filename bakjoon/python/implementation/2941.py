word=input().strip()
ans=0
idx=0
#크로아티아 알파벳 목록
alpha=['c=','c-','dz=','d-','lj','nj','s=','z=']

for i in alpha:
    #크로아티아의 알파벳 목록이 단어에 포함되면 그 단어를 +로 교체
    word=word.replace(i,'+')
print(len(word))
