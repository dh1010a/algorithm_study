import java.util.*;
import java.util.stream.Collectors;
class Solution {
    Stack<Integer> stack = new Stack<>();

    public int solution(int[] order) {
        int answer = 0;
        int len = order.length;
        int now = 0;
        for (int i = 1; i <= len; i++) {
                stack.push(i);
                while(!stack.empty() && stack.peek() == order[now]) {
                    now++;
                    answer++;
                    stack.pop();
                }
            }
        
        while(!stack.empty() && stack.peek() == order[now]) {
                now++;
                answer++;
                stack.pop();
        }
        
        
        return answer;
    }
}