import sys
input=sys.stdin.readline
array=[]
def lotto(start,idx):
    if idx==6:
        for i in range(6):
            print(lottos[i],end=' ')
        print()
        return
    for i in range(start,len(array)):
        lottos[idx]=array[i]
        lotto(i+1,idx+1)

lottos=[0 for i in range(13)]
while True:
    array.clear()
    n=input().split()
    for i in range(len(n)):
        array.append(int(n[i]))
    if array[0]==0:
        break
    else:
        del array[0]
        lotto(0,0)
    print()
    
    
    
