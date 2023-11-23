def solution(survey, choices):
    answer = ''
    dicItem = "RTCFJMAN"
    dic = {}
    index = [('R','T'),('C','F'),('J','M'),('A','N')]
    for item in dicItem.strip():
        dic[item] = 0
    for i in range(len(choices)):
        a,b = survey[i].strip()
        choice = choices[i]
        if choice == 4 :
            continue
        if choice > 4 :
            dic[b] += (choice - 4)
        else :
            dic[a] += (4 - choice)
    for left, right in index :
        if dic[left] == dic[right] :
            answer += left
        elif dic[left] > dic[right] :
            answer += left
        else :
            answer += right
    return answer