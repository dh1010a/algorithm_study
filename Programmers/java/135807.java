import java.util.*;

class Solution {


    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        List<Integer> aList = new ArrayList<>();
        List<Integer> bList = new ArrayList<>();

        int agcd = arrayA[0];
        for (int i = 1; i < arrayA.length; i++) {
            agcd = gcd(agcd, arrayA[i]);
        }
        
        int bgcd = arrayB[0];
        for (int i = 1; i < arrayB.length; i++) {
            bgcd = gcd(bgcd, arrayB[i]);
        }

        int x = 1;
        while (x * x <= agcd) {
            if (agcd % x == 0) {
                aList.add(x);
                aList.add(agcd / x);
            }
            x++;
        }

        x = 1;
        while (x * x <= bgcd) {
            if (bgcd % x == 0) {
                bList.add(x);
                bList.add(bgcd / x);
            }
            x++;
        }

        for (int i = 0; i < aList.size(); i++) {
            int tmp = aList.get(i);
            if (isPossible(arrayB, tmp)) {
                answer = Math.max(answer, tmp);
            }   
        }

        for (int i = 0; i < bList.size(); i++) {
            int tmp = bList.get(i);
            if (isPossible(arrayA, tmp)) {
                answer = Math.max(answer, tmp);
            }  
        }



        return answer;
    }

    public boolean isPossible(int[] array, int x) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] % x == 0) {
                return false;
            }
        }
        return true;
    }

    public int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        } else {
            return gcd(b, a % b);
        }
    }


}
