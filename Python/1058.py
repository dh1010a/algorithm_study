import sys
input=sys.stdin.readline

for k in range(3):
    
    num = int(input(""))
    alist = []

    
    for i in range(0, num):
        num_1 = int(input(""))
        alist.append(num_1)

    applynum = 0
    for y in range(0, len(alist)):
    
        applynum += (alist[y])
    
    if applynum > 0:
        print("+")
    elif applynum == 0:
        print("0")
    else:
        print("-")

    