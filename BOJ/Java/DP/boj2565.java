import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] arr;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());

        arr = new int[N][2];
        dp = new int[N];



        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));

        // Arrays.sort(arr, Comparator<int[]>() {
        //     @Override
        //     public int compare(int[] o1, int[] o2) {
        //         return o1[0] - o2[0];
        //     }
        // });

        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i][1] > arr[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int result = N - Arrays.stream(dp).max().getAsInt();
        bw.write(result + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

}