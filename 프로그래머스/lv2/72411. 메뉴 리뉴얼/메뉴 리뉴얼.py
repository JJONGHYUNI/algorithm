from itertools import combinations
answer=[]
def solution(orders, course):
    for i in range(len(orders)):
        orders[i]=list(orders[i].strip(""))
        orders[i].sort()
    for i in course:
        courseMenu=[]
        for j in orders:
            courseMenu.append(list(combinations(j,i)))
        menu(courseMenu)
    answer.sort()
    return answer

def menu(courseMenu):
    dic={}
    for i in courseMenu:
        for j in i:
            tmp="".join(j)
            if tmp in dic.keys():
                dic[tmp]+=1
            else:
                dic[tmp]=1
    if dic:
        maxLen=max(dic.values())
        for i in dic.keys():
            if maxLen==1:
                break
            if dic[i]==maxLen:
                answer.append(i)