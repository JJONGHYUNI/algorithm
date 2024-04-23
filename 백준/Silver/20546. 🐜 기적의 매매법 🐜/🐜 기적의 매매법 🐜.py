import sys
input=sys.stdin.readline

money=int(input())
chart=list(map(int,input().split()))
jun=[money,0]
sung=[money,0]

for i in range(14):
    while jun[0]>=chart[i]:
        jun[0]-=chart[i]
        jun[1]+=1
    if i>2 :
        if chart[i-3]<chart[i-2]<chart[i-1] and sung[1]!=0:
            sung[0]=sung[0]+sung[1]*chart[i]
            sung[1]=0
        elif chart[i-3]>chart[i-2]>chart[i-1]:
            while sung[0]>=chart[i]:
                sung[0]-=chart[i]
                sung[1]+=1
sung[0]=sung[0]+sung[1]*chart[13]
jun[0]=jun[0]+jun[1]*chart[13]

if sung[0]>jun[0]:
    print("TIMING")
elif sung[0]<jun[0]:
    print("BNP")
else:
    print("SAMESAME")
