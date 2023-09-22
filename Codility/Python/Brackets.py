# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")

def solution(S):
    # Implement your solution here
    stack = []
    tmp = [')', '}', ']']
    if len(S) == 0:
        return 1
    for i in S:
        if i not in tmp:
            stack.append(i)
        else:
            if len(stack) == 0:
                return 0
            elif i == tmp[0] and stack[-1] == '(':
                stack.pop()
            elif i == tmp[1] and stack[-1] == '{':
                stack.pop()
            elif i == tmp[2] and stack[-1] == '[':
                stack.pop()
    if len(stack) == 0:
        return 1
    else:
        return 0


def solution(S):
    reverse_c = {')': '(', ']':'[', '}':'{'}
    stacks = []
    for s in S:
        s_ = reverse_c.get(s, -1)
        if s_ == -1: # open
            stacks.append(s)
        else: # close
            if len(stacks) == 0 or s_ != stacks[-1]:
                return 0
            else:
                stacks.pop()
    return int(len(stacks) == 0)