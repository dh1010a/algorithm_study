// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // Implement your solution here
        int answer = Integer.MAX_VALUE;
        int tsum = Arrays.stream(A).sum();
        int[] arr = new int[A.length];
        arr[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            arr[i] = arr[i-1] + A[i];
        }
        for (int i = 0; i < arr.length - 1; i++) {
            answer = Math.min(answer, Math.abs(arr[i] - (tsum - arr[i])));
        }
        return answer;
    }
}
