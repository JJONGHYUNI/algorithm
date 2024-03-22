def solution(genres, plays):
    answer = []
    d = {}
    dd = {}
    for i in range(len(genres)):
        genre, play = genres[i], plays[i]
        if genre not in d:
            d[genre] = []
            dd[genre] = 0
        d[genre].append([play, i])
        dd[genre] += play
    dd = sorted(dd, key = lambda x : -dd[x])
    for i in dd:
        d[i] = sorted(d[i], key = lambda x : (-x[0], x[1]))
        answer.append(d[i][0][1])
        if len(d[i]) >= 2:
            answer.append(d[i][1][1])
    return answer