S = list(input())

c = True
for i in range(len(S)):
    if S[i] != S[len(S) - 1 - i]:
        c = False
        break

if c:
    print("1")
else:
    print("0")