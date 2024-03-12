def solution(prices):
    answer = []
    for i in range(len(prices)):
        price = prices[i]
        cnt = 0
        con = 1
        for j in range(i+1, len(prices)):
            price2 = prices[j]
            cnt += 1
            if price2 < price:
                answer.append(cnt)
                con = 0
                break
        if con:
            answer.append(cnt)
    return answer