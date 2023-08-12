import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        for(int x : priorities) {
            list.add(x);
        }
        while(location >= 0) {
            System.out.println(list.get(0));
            int max = Collections.max(list);
            if(list.get(0) >= max) {
                list.remove(0);
                location--;
                answer++;
                if(location < 0) {
                    break;
                }
            } else {
                int tmp = list.get(0);
                list.remove(0);
                list.add(tmp);
                location--;
                if(location < 0) {
                    location = list.size()-1;
                }
            }
        }
        return answer;
    }
}
//PriorityQueue를 이용한 풀이
import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		for(int num : priorities) {
			pq.add(num);
		}
		while(!pq.isEmpty()) {
			for(int i=0; i<priorities.length; i++) {
				if(priorities[i] == pq.peek()) {
					pq.poll();
					answer++;
					if(i == location)
						return answer;
				}
			}
		}  
        return answer;
    }
}