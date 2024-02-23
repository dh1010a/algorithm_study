import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> kind = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            if (kind.containsKey(clothes[i][1])) {
                kind.replace(clothes[i][1], kind.get(clothes[i][1]) + 1);
            } else {
                kind.put(clothes[i][1], 1);
            }
        }
        for (String key : kind.keySet()) {
            answer *= kind.get(key) + 1;
        }
        
        return answer - 1;
    }
}