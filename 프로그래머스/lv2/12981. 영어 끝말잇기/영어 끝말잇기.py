from collections import deque
def solution(n, words):
    answer = []
    q=deque(words)
    word=[]
    cnt=0
    control=1
    while control and q:
        cnt+=1
        for i in range(n):
            if not q:
                break
            w=q.popleft()
            if w in word:
                answer.append(i+1)
                answer.append(cnt)
                control=0
                break
            if word and word[-1][-1]!=w[0]:
                answer.append(i+1)
                answer.append(cnt)
                control=0
                break
            word.append(w)
    if not answer:
        answer=[0,0]
        

    return answer