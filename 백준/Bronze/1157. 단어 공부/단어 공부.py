import sys
input = sys.stdin.readline

arr = [0] * 26
word = input().strip()
word = word.upper()

for c in word:
    arr[ord(c) - 65] += 1

mx = max(arr)
ans = []
for i in range(0, 26):
    if (mx == arr[i]):
        ans.append((chr) (i + 65))
if len(ans) == 1:
    print(ans[0])
else:
    print("?")
