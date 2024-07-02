import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> kind = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            kind.put(clothes[i][1], kind.getOrDefault(clothes[i][1], 0) + 1);
        }
        for (String key : kind.keySet()) {
            answer *= kind.get(key) + 1;
        }
        
        return answer - 1;
    }
}