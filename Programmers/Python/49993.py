def solution(skill, skill_trees):
    answer = 0
    for i in skill_trees:
        arr = list(i)
        find = []
        for j in arr[:]:
            if j not in skill:
                arr.remove(j)
            else:
                find.append(skill.index(j))
        if len(find) <= 1:
            if len(find) == 0:
                answer += 1
            elif find[0] == 0:
                answer += 1
            
        else:
            if sorted(find) == find and min(find) == 0:
                if max(find) - min(find) == len(find)-1:
                    answer += 1
            
            
    return answer