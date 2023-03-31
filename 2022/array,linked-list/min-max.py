#10818
n=int(input(""))
number=list(map(int,input("").split()))
maxnum=number[0]
minnum=number[0]
for i in range(n-1):
    if(maxnum<number[i+1]):
        maxnum=number[i+1]
    elif(minnum>number[i+1]):
        minnum=number[i+1]
print(minnum,maxnum)
