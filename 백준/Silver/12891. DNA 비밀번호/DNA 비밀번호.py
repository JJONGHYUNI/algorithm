# start 16:21
# end   16:50
import sys
input = sys.stdin.readline

s, p = map(int, input().split())
d = list(input().strip())
a, c, g, t = map(int,input().split())
dic = {}
dic['A'], dic['C'], dic['G'], dic['T'] = 0, 0, 0, 0
dna = ['A','C','G','T']
answer = 0
cnt = 0 
for i in range(s):
    tmp = d[i]
    cnt += 1
    if tmp in dna:
        dic[tmp] += 1
    else:
        dic['A'], dic['C'], dic['G'], dic['T'] = 0, 0, 0, 0
        cnt = 0
        continue
    if cnt == p:
        if dic['A'] >= a and dic['C'] >= c and dic['G'] >= g and dic['T'] >= t:
            answer += 1
        dic[d[i-p+1]] -= 1
        cnt -= 1
print(answer)
