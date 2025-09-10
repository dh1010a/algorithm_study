import java.util.*;

class pgs60057 {
    public int solution(String s) {
        int answer = 1000;
        if (s.length() == 1) {
            return 1;
        }

        for (int i = 1; i < s.length() / 2 + 1; i++) {
            Deque<String> dq = new ArrayDeque<>();
            int idx = 0;
            while(idx + i < s.length()) {
                dq.add(s.substring(idx, idx + i));
                idx += i;
            }
            // 뒷부분 남은 경우
            if (!s.substring(idx, s.length()).equals("")) {
                dq.add(s.substring(idx, s.length()));
            }

            int len = 0;
            while (!dq.isEmpty()) {
                String now = dq.remove();
                int cnt = 1;
                while(!dq.isEmpty() && dq.peek().equals(now)) {
                    dq.remove();
                    cnt++;
                }
                len += (cnt == 1 ? 0 : getLength(cnt)) + now.length();
            }

            answer = Math.min(len, answer);
        }

        return answer;
    }

    public int getLength(int size) {
        if (size < 10) {
            return 1;
        } else {
            return getLength(size / 10) + 1;
        }
    }
}