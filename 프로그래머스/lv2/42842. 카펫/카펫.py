def solution(brown, yellow):
    answer = []

    for i in range(1,yellow+1):
        if yellow%i==0:
            height=yellow//i
            if (i+2)*2+(height+2)*2-4==brown and i>=height:
                answer=[i+2,height+2]
                break
    return answer