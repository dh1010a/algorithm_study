package D4;

import java.io.*;
import java.util.*;

public class swea3752 {

    static int N;
    static int[] arr;
    static Set<Integer> set;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++) {
            set = new HashSet<>();
            N = Integer.parseInt(br.readLine());
            arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine(), "");

            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            System.out.println("#" + tc + " " + set.size());

        }
    }

    public static void dfs(int N, int now, int sum) {
        if (now == N) {
            set.add(sum);
            return;
        }

        for (int i = now; i < N; i++) {
            dfs(N, i + 1, sum + arr[i]);
        }
    }
}
