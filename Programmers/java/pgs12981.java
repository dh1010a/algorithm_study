import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        int now = 1;
        List<String> known_word = new ArrayList<>();
        known_word.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            if (words[i-1].charAt(words[i-1].length() - 1) != words[i].charAt(0) ||
               known_word.contains(words[i])) {
                answer[0] = now % n + 1;
                answer[1] = now / n + 1;
                return answer;
            }
            known_word.add(words[i]);
            now++;
            
        }
    

        return answer;
    }
}