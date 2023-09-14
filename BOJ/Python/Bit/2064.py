import sys
input = sys.stdin.readline

n = int(input())
ip_arr = [input().strip().split('.') for _ in range(n)]
mask_arr = []
net_addr = []
diff = 0
for i in range(4):
    min_ip = int(ip_arr[0][i])
    max_ip = int(ip_arr[0][i])
    for j in ip_arr:
        min_ip = min(int(j[i]), min_ip)
        max_ip = max(int(j[i]), max_ip)
    if 255 == 256 + (~max_ip ^ min_ip):
        mask_arr.append(255)
    else:
        for j in range(9):
            if -(~max_ip ^ min_ip) <= 1 << j:
                mask_arr.append(256 - (1 << j))
                for k in range(3):
                    mask_arr.append(0)
                break
    net_addr.append(int(ip_arr[0][i]) & mask_arr[i])
net_mask = mask_arr[:4]
        

print("{}.{}.{}.{}".format(net_addr[0], net_addr[1], net_addr[2], net_addr[3]))
print("{}.{}.{}.{}".format(mask_arr[0], mask_arr[1], mask_arr[2], mask_arr[3]))