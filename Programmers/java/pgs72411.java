import java.util.*;

class Solution {
    
    Map<String, Integer> map = new HashMap<>();
    int[] max;
    
    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        max = new int[course.length];
        
        for (String x: orders) {
            char[] charArr = x.toCharArray();
            Arrays.sort(charArr);
            String str = String.copyValueOf(charArr);
            for (int i = 0; i < course.length; i++) {
                dfs(str, "",0 ,i ,course[i]);
            }
            
        }
        for (Map.Entry<String, Integer> x : map.entrySet()) {
            for (int i = 0; i < course.length; i++) {
                if (x.getKey().length() == course[i] && max[i] >= 2 && max[i] == x.getValue()) {
                    answer.add(x.getKey());
                }
            }
        }

        return answer.stream().sorted().toArray(String[]::new);
    }
    
    public void dfs(String arr, String str, int start, int locate, int len) {
        
        if (str.length() == len) {
            map.put(str, map.containsKey(str) ? map.get(str) + 1 : 1);
            max[locate] = Math.max(max[locate], map.get(str));
        }
        
        for (int i = start; i < arr.length(); i++) {
            dfs(arr, str + arr.charAt(i), i + 1, locate, len);
        }
    }
}