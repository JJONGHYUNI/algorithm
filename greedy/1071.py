import sys
input=sys.stdin.readline

N=int(input())
num=[int(i) for i in input().split()]
csort=[0 for i in range(1002)]
for i in range(N):
    csort[num[i]]+=1

answer=''
while True:
    control = False
    for i in range(1001):
        if csort[i]:
            control=True
            if csort[i+1]:
                k=-1
                for j in range(i+2,1001):
                    if(csort[j]):
                        k=j
                        break
                if k != -1:
                    while csort[i]:
                        answer+=str(i)+' '
                        csort[i]-=1
                    answer+=str(k)+' '
                    csort[k]-=1
                    break
                else:
                    answer+=str(i+1)+' '
                    csort[i+1]-=1
                    break
            else:
                while(csort[i]):
                    answer+=str(i)+' '
                    csort[i]-=1
                break
    if control==False:
        break
print(answer)
