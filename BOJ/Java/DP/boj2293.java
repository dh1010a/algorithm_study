import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

        arr = new int[N];
        dp = new int[K + 1];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        dp[0] = 1;

        for (int i = 0; i < N; i++) {
            int n = arr[i];
            for (int j = n; j <= K; j++) {
                dp[j] += dp[j-n]; 
            }
        }
        
        bw.write(dp[K] + "\n");



        br.close();
        bw.flush();
        bw.close();
    }

}