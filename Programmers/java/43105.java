import java.util.*;
class Solution {
    
    public boolean isRange(int i, int j) {
        return j >= 0 && j < i+1;
    }
    
    public int solution(int[][] triangle) {
        for(int i = 1; i < triangle.length; i++) {
            for(int j = 0; j < i+1; j++) {
                int x = 0;
                int y = 0;
                if(isRange(i-1, j-1)) {
                    x = triangle[i-1][j-1];
                }
                if(isRange(i-1, j)) {
                    y = triangle[i-1][j];
                }
                triangle[i][j] += Math.max(x, y);
            }
        }
        int answer = Arrays.stream(triangle[triangle.length-1]).max().getAsInt();
        return answer;
    }
}