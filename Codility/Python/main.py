def solution(A):
	size = 0
	for k in range(len(A)):
		if (size == 0):
			size += 1
			candidate = A[k]
		else:
			if (candidate != A[k]):
				size -= 1
			else:
				size += 1
	if size <= 0:
		return 0
	idx = [0]
	for k in range(len(A)):
		offset = 0
		if (A[k] == candidate):
			offset = 1
		idx.append(idx[-1]+offset)
	res = 0
	print(idx)
	if (idx[-1] > len(A) // 2):
		for i, k in enumerate(idx[1:]):
			if k>(i+1)//2 and idx[-1] - k > (len(A) - (i+1))//2:
				res += 1
				print(i, k)

	return res