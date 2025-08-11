import java.util.*;
class Solution {
    public int solution(int[] picks, String[] minerals) {
        int max_area = 0;
        int size = minerals.length;
        for (int i = 0; i < 3; i++) {
            max_area = picks[i];
        }
        max_area = Math.min(max_area, size % 5 == 0 : size / 5 : size / 5 + 1);
        int[][] info = new int[3][max_area];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < Math.min(5 * max_area, minerals.length); j++) {

            }
        }


        return answer;
    }
}