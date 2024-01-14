N,M = list(map(int,input().split()))

matrix_a = [[0 for j in range(M)] for i in range(N)]
matrix_b = matrix_a.copy()

for i in range(N):
    matrix_a[i] = (list(map(int,input().split())))

for i in range(N):
    matrix_b[i] = (list(map(int,input().split())))

for i in range(N):
    for j in range(M):
        print(matrix_b[i][j] + matrix_a[i][j],end=" ")
    print()