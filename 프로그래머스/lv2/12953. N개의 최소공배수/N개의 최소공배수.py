def solution(arr):
    arr.sort()
    ans=gcd(arr[0],arr[1])
    for i in range(2,len(arr)):
        ans=(gcd(ans,arr[i]))
        print(ans)
    return ans
        

def gcd(a,b):
    A,B=a,b
    while b>0:
        a,b=b,a%b
    return A*B//a
            