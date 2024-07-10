import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] dp, arr;
    static int MAX_VALUE = 1000 * 1000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
        dp = new int [N][3];
        arr = new int [N][3];

        int answer = MAX_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }
        dp = new int [N][3];
        for (int k = 0; k < 3; k++) {

            dp[0][k] = arr[0][k];
            dp[0][(k+1) % 3] = MAX_VALUE;
            dp[0][(k+2) % 3] = MAX_VALUE;

            for (int i = 1; i < N; i++) {
                for (int j = 0; j < 3; j++) {
                    dp[i][j] = Math.min(dp[i-1][(j+1) % 3], dp[i-1][(j+2) % 3]) + arr[i][j];
                }
            }

            answer = Math.min(Math.min(dp[N-1][(k+1) % 3], dp[N-1][(k+2) % 3]), answer);

            // System.out.println();
            // for (int t = 0; t < N; t++) {
            //     System.out.println(dp[t][0] + " " + dp[t][1] + " " + dp[t][2]);
            // }
        }
        bw.write(answer + "\n");

        

        br.close();
        bw.flush();
        bw.close();
    }

}