import java.util.*;
class pgs60057 {
    public int solution(String s) {
        List<Integer> answer = new ArrayList<>();
        for (int i = 1; i <= s.length(); i++) {
            Queue<String> q = new LinkedList<>();
            int j = 0;
            while (j + i <= s.length()) {
                q.add(s.substring(j, j + i));
                j += i;
            }
            if (!s.substring(j, s.length()).equals("")) {
                q.add(s.substring(j, s.length()));
            }
            String x = "";
            while (!q.isEmpty()) {
                
                String now = q.poll();
                int n = 1;
                while (!q.isEmpty() && q.peek().equals(now)) {
                    q.poll();
                    n++;
                }
                
                x = n!=1 ? x + n + now : x + now;
                
            }
            answer.add(x.length());
        }
        return Collections.min(answer);
    }
}