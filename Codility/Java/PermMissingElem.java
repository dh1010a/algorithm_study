import java.util.*;
class Solution {
    public int solution(int[] A) {
        Arrays.sort(A);
        for (int i = 0; i < A.length; i++) {
            if (i + 1 != A[i]) {
                return i + 1;
            }
        }
        return A.length + 1;
    }
}
// 처음 푼 풀이
import java.util.*;

class Solution {
    public int solution(int[] A) {
        // Implement your solution here
        Arrays.sort(A);
        int flag = A.length/2, start = 0, end = A.length - 1;
        if (A.length < 2) {
            if (A.length == 0) return 1;
            else if (A.length == 1) {
                return A[0] == 1 ? 2 : 1;
            }
        }
        if (A[start] != 1) {
            return 1;
        }
        if (A[end] != A.length + 1) {
            return A.length + 1;
        }
        while (end - start != 1) {
            if (A[flag] == flag + 1) {
                start = flag;
                flag = (start + end) / 2;
            } else if (A[flag] > flag + 1) {
                end = flag;
                flag = (start + end) / 2;
            }
        }
        return start + 2;
    }
}