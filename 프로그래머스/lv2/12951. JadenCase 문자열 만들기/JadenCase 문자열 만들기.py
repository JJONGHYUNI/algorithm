def solution(s):
    arr=list(s.split(" "))
    answer = ''
    for word in arr:
        word=word.lower()
        if len(word):
            if word[0].isalpha():
                 if len(word)>=2:
                     word=word[0].upper()+word[1:]
                 else:
                     word=word[0].upper()
        answer+=word+" "
    answer=answer[0:len(answer)-1]
    return answer