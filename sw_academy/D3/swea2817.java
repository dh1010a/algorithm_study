package D3;

import java.util.*;

public class swea2817 {

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int tc = 1; tc <= T; tc++) {
            int N, K;
            N = sc.nextInt();
            K = sc.nextInt();

            int[] arr = new int[N];

            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            int result = 0;

            int i = 0;
            int j = 0;
            int sum = 0;
            while (i <= j) {
                if (sum < K) {
                    j++;
                    sum += arr[j];
                } else if (sum > K) {
                    sum -= arr[i];
                    i++;
                    sum += arr[i];
                }
                else {
                    result++;
                    sum -= arr[i];
                    i++;
                }
            }
            System.out.println("#" + tc + " " + result);
        }
    }
}
