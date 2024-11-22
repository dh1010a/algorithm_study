import java.util.*;
class pgs42584 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        for (int i = 0; i < prices.length - 1; i++) {
            int time = 0;
            for (int j = i + 1; j < prices.length; j++) {
                time++;
                if (prices[i] > prices[j]) {
                    break;
                }
            }
            answer[i] = time;
        }
        answer[prices.length - 1] = 0;
        return answer;
    }

    //Deque 사용 풀이
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < prices.length; i++) {
            while(!dq.isEmpty() && prices[i] < prices[dq.peekLast()]) {
                answer[dq.peekLast()] = i - dq.peekLast();
                dq.removeLast();
            }
            dq.add(i);
        }
        while (!dq.isEmpty()) {
            answer[dq.peekLast()] = prices.length - dq.peekLast() - 1;
            dq.removeLast();
        }


        return answer;
    }
}