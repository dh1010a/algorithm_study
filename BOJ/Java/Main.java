import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static long[] arr;
    static long[] dp;
    static long[] remain;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

        arr = new long[N];
        dp = new long[N];
        remain = new long[N];

        int result = 0;

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp[0] = arr[0];
        for (int i = 1; i < N; i++) {
            dp[i] = dp[i-1] + arr[i];
        }

        // dp배열을 모두 M으로 나누어 준다
        dp = Arrays.stream(dp).map(x -> x % M).toArray();

        // 나누어진 배열에 0 이 있다면 0번쨰 원소부터 해당 자리까지의 합이 M으로 나누어 떨어짐을 의미한다
        for (int i = 0; i < N; i++) {
            if (dp[i] % M == 0) {
                result++;
            }
            remain[(int) dp[i]]++;
        }


        for (int i = 0; i < N; i++) {
            if (remain[i] > 1) {
                result += remain[i] * (remain[i] - 1) / 2;
            }
        }
        


        bw.write(result + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

}