import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        dp = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp[0] = arr[0];
        for (int i = 1; i < N; i++) {
            dp[i] = dp[i-1] + arr[i];
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int result = x > 1 ? dp[y - 1] - dp[x - 2] : dp[y - 1];
            bw.write(result + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

}