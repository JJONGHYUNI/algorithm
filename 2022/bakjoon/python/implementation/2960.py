import sys
input=sys.stdin.readline

n,k = map(int,input().split())

#지운건지 안지운건지 확인
is_prime=[0]*1001

#소수 담을 list
prime_list=[]
def prime():
    #2부터 검사
    temp=2
    idx=0
    #temp가 n보다 커지면 종료
    while temp<=n:
        #temp가 아직 검사가 안된 수일 경우 진행
        if not is_prime[temp]:
            #배수
            m=1
            #배수 지우기
            while temp*m<=n:
                #이미 지워진 부분 지나치기
                if is_prime[temp*m]:
                    m+=1
                    continue
                is_prime[temp*m]=1
                prime_list.append(temp*m)
                m+=1
                idx+=1
        temp+=1
    

prime()
print(prime_list[k-1])
