def isEssense(d) :
    dd = int (d)
    if d == dd :
        if dd <= 1000:
            return dd
    return 0

def solution(weights):
    answer = 0
    dp = [0] * 1001
    for weight in weights:
        dp[weight] += 1
    
    for i in range(1001):
        d = dp[i]
        twoFour = isEssense(i * 2)
        twoThree = isEssense(i * 1.5)
        threeFour = isEssense(i * (4/3))
        
        if d == 0:
            continue
            
        answer += d * dp[twoFour]
        answer += d * dp[twoThree]
        answer += d * dp[threeFour]
        
        while d != 0 :
            d -= 1
            answer += d
    return answer
