import sys
input=sys.stdin.readline
grade=['A+', 'A0', 'B+', 'B0', 'C+', 'C0', 'D+', 'D0','F']
score=[4.5, 4.0, 3.5, 3.0, 2.5, 2.0, 1.5, 1.0, 0.0]
total=0
division=0
for i in range(20):
    a,b,c=input().split()
    if c=="P":
        continue
    b=float(b)
    division+=b
    idx=grade.index(c)
    total+=score[idx]*b
print(round(total/division,6))
