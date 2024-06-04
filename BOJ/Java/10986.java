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
        remain = new long[M];

        long result = 0;

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        dp[0] = arr[0];
        for (int i = 1; i < N; i++) {
            dp[i] = dp[i-1] + arr[i];
        }

        // dp배열을 모두 M으로 나누어 준다
        dp = Arrays.stream(dp).map(x -> x % M).toArray();

        for (int i = 0; i < N; i++) {
            int tmp = (int) (dp[i] % M);
            // 나누어진 배열에 0 이 있다면 0번쨰 원소부터 해당 자리까지의 합이 M으로 나누어 떨어짐을 의미한다
            if (tmp == 0) {
                result++;
            }
            // 나머지가 같은 원소의 갯수를 기록하기 위해 배열을 사용한다.
            remain[tmp]++;
        }


        for (int i = 0; i < M; i++) {
            if (remain[i] > 1) {
                // 나머지가 같은 원소의 갯수를 중복없이 2개 뽑는 경우의 수를 구해 더한다.
                result += (remain[i] * (remain[i] - 1)) / 2;
            }
        }
        


        bw.write(result + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

}