import java.util.*;
class Solution {
    static boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        int answer = 0;
        List<List<int[]>> list = new ArrayList<>();
        visited = new boolean[dungeons.length];
        
        dfs(dungeons, new ArrayList<>(), list);
        
        
        for (List<int[]> x: list) {
            int tmp = k;
            int cnt = 0;
            for (int[] arr: x) {
                if (arr[0] > tmp) {
                    break;
                }
                tmp -= arr[1];
                cnt++;
            }
            answer = Math.max(cnt, answer);
        }
        
        return answer;
    }
    
    public void dfs(int[][] dungeons, List<int[]> nowList, List<List<int[]>> list) {
        if (nowList.size() == dungeons.length) {
            list.add(new ArrayList<>(nowList));
            return;
        }
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i]) {
                nowList.add(dungeons[i]);
                visited[i] = true;
                dfs(dungeons, nowList, list);
                visited[i] = false;
                nowList.remove(nowList.size()-1);
            }
        }
    }
}