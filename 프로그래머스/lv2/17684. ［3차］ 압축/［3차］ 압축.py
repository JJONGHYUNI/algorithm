from collections import deque
def solution(msg):
    answer = []
    q=deque(msg.strip())
    word=""
    dic=['a','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z']
    while q:
        word+=q.popleft()
        end=0
        while word in dic:
            if q:
                word+=q.popleft()
            else:
                end=1
                break
        if end:
            if word in dic:
                answer.append(dic.index(word))
                word=''
        else:
            tmp=word[0:len(word)-1]
            dic.append(word)
            answer.append(dic.index(tmp))
            word=word[-1]
    if word in dic:
        answer.append(dic.index(word))
    print(dic)
    return answer