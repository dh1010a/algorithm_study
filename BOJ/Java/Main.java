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

        dp = new int[K + 1];
        
        Set<Integer> set = new HashSet<Integer>();

        for (int i = 0; i < N; i++) {
            set.add(Integer.parseInt(br.readLine()));
        }

        arr = set.stream().mapToInt(Integer::intValue).toArray();
        
        for (int i = 0; i <= K; i++) {
            dp[i] = 10001;
        }
        dp[0] = 0;

        for (int i = 0; i < arr.length; i++) {
            int n = arr[i];
            for (int j = n; j <= K; j++) {
                dp[j] = Math.min(dp[j], dp[j-n] + 1); 
            }
        }
        if (dp[K] == 10001) {
            bw.write("-1\n");
        } else {
            bw.write(dp[K] + "\n");
        }
        



        br.close();
        bw.flush();
        bw.close();
    }

}