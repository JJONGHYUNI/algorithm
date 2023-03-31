import sys
input=sys.stdin.readline

T=int(input())

for _ in range(T):
    coor=list(map(int,input().split()))
    distance=((coor[3]-coor[0])**2+(coor[4]-coor[1])**2)**(1/2)
    if distance==0:
        if coor[2]==coor[5]:
            print(-1)
        else:
            print(0)
    else:
        if distance==coor[2]+coor[5] or distance==abs(coor[2]-coor[5]):
            print(1)
        elif distance<coor[2]+coor[5] and distance>abs(coor[2]-coor[5]):
            print(2)
        else:
            print(0)
