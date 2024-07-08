import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        Queue<Character> q = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            q.add(s.charAt(i));
        }
        int n = 0;
        if (s.length()%2 != 0) return 0;
        while (n < s.length()) {
            if (isRight(q)) answer++;
            q.add(q.poll());
            n++;
        }
        return answer;
    }
    
    public boolean isRight(Queue<Character> q) {
        Stack<Character> stack = new Stack<>();
        for (char c: q) {
            if (c == '[' || c == '(' || c == '{') {
                stack.push(c);
            }
            else {
                if (!stack.isEmpty() && isSame(stack.peek(), c)) {
                    stack.pop();
                } 
            }
        }
        return stack.isEmpty() ? true : false;
    }
    
    public boolean isSame(char left, char right) {
        if (left == '[' && right == ']') return true;
        if (left == '(' && right == ')') return true;
        if (left == '{' && right == '}') return true;
        return false;
    }
}