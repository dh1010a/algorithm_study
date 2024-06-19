import java.io.*;
import java.util.*;

class Main {
    static int N;
    static int[] arr, dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        dp = new int[N][N];

        if (n == 1) {
            System.out.println("10");
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dp[i][j] = 1;
            }
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 10; j++) {

            }
        }


        bw.write(result + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}