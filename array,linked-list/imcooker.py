score=[list(map(int,input().split())) for _ in range(5)]
winscore=[0,0,0,0,0]
for i in range(5):
    for j in range(4):
        winscore[i]+=score[i][j]
for i in range(4):
    if(winscore[0]<winscore[i+1]):
        winscore[0]=winscore[i+1]
    elif(winscore[0]>winscore[i+1]):
        winscore[0]=winscore[0]
for i in range(5):
    if (winscore[0]==winscore[i]):
        winnum=i+1
print(winnum,winscore[0])

        
