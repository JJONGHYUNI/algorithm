import sys
input=sys.stdin.readline
t=int(input())
def find(phonebook):
    for i in range (len(phonebook)-1):
        if(phonebook[i]==phonebook[i+1][0:len(phonebook[i])]):
            return "NO"
for _ in range(t):
    n=int(input())
    tree=[]
    for _ in range(n):
        number=input()
        tree.append(number.rstrip())
    tree.sort()
    answer=find(tree)
    if answer==None:
        answer="YES"
    print(answer)
    
        
