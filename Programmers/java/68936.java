import java.util.*;
class Solution {
    public int[] answer = new int[2];
    
    public int[] solution(int[][] arr) {
        dfs(arr, 0, 0, arr.length);
        return answer;
    }
    
    public void dfs(int[][] arr, int x, int y, int len) {
        if (isSame(arr, x, y, len)) {
            answer[arr[x][y]]++;
            return;
        }
        dfs(arr, x, y, len/2);
        dfs(arr, x + len/2, y, len/2);
        dfs(arr, x, y + len/2, len/2);
        dfs(arr, x + len/2, y + len/2, len/2);
    }
    
    public boolean isSame(int[][] arr, int x, int y, int len) {
        int tmp = arr[x][y];
        for (int i = x; i < x + len; i++) {
            for (int j = y; j < y + len; j++) {
                if (arr[i][j] != tmp) {
                    return false;
                }
            }
        }
        return true;
    }
}