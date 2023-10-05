from collections import defaultdict
def solution(A):
    if len(A) == 1:
        return 0
    else:
        answer = 0
        cnt = 0
        lead_num = 0
        diction = defaultdict(int)
        for i, num in enumerate(A):
            diction[num] += 1
            if diction[num] > len(A)/2:
                lead_num = num
        for i, num in enumerate(A):
            if num == lead_num:
                cnt += 1
            if cnt > (i + 1) / 2 and diction[lead_num] - cnt > (len(A)-i-1)/2:
                answer += 1
        return answer