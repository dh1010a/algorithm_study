def solution(survey, choices):
    answer = ''
    arr = dict()
    for i in 'RTCFJMAN':
        arr[i] = 0
    for i in range(len(survey)):
        if choices[i] == 4:
            continue
        elif choices[i] > 4:
            arr[survey[i][1]] += choices[i] - 4
        else:
            arr[survey[i][0]] += 4 - choices[i]
            
    for i in ["RT","CF","JM", "AN"]:
        if arr[i[1]] > arr[i[0]]:
            answer += i[1]
        else:
            answer += i[0]
    return answer