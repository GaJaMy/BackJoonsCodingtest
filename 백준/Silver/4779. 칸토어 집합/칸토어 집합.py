import sys

def func(arr):
    if len(arr) == 1:
        return "-"
    
    idx = len(arr) // 3 

    left = func(arr[:idx])
    mid = func(arr[idx:(idx * 2)])
    right = func(arr[idx*2:])
    
    i = 0
    r = ""
    r += left
    while i < len(mid):
        r += " "
        i += 1
    r += right

    return r


while True:
    try:
        N = int(sys.stdin.readline())
        arr = '-' * (3 ** N)
        result = func(arr)
        print(''.join(result))
    except:
        break
       

            