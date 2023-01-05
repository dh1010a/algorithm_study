x = int(input())
arr = [64]
while sum(arr) != x:
    arr.sort()
    if sum(arr) > x:
        if not arr[0] // 2 + (sum(arr) - arr[0]) > x:
            arr.append(arr[0]//2)
        arr[0]//=2
        print(arr)
ans = 0
for i in arr:
    if i != 0:
        ans += 1
print(ans)
