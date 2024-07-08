import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] arr;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());

        dp = new int[N+1];
        arr = new int [N][2];

        int answer = 0;
        

        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i <= N; i++) {
            
            for (int j = 0; j < i; j++) {
                dp[i] = Math.max(dp[i], dp[j]);
                if (j + arr[j][0] == i) {
                    dp[i] = Math.max(dp[i], dp[j] + arr[j][1]);
                }
            }


        }

        answer = Arrays.stream(dp).max().getAsInt();


        bw.write(answer + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

}