def solution(nums):
    answer = 0
    s1 = set()
    for i in nums:
        s1.add(i)
    return len(nums)//2 if len(s1) >= len(nums) // 2 else len(s1)