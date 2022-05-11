import sys
input=sys.stdin.readline
height=[int(input()) for _ in range(9)]
height.sort()
sum=0
for i in range(9):
    sum+=height[i]
find1,find2=0,0
for i in range(9):
    for j in range(i+1,9):
        if sum-(height[i]+height[j])==100:
            find1=height[i]
            find2=height[j]

del height[height.index(find1)]
del height[height.index(find2)]
print('\n'.join(map(str,height)))
