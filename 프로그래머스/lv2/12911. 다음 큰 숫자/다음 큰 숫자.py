def solution(n):
    l=str(bin(n)[2:])
    l=len(l.replace('0',""))
    print(l)
    while True:
        n+=1
        tmp=str(bin(n)[2:])
        tmp=len(tmp.replace('0',""))
        if l==tmp:
            break
    return n