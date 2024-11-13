package D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea1220 {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T=10;

        for(int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[][] table = new int[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    table[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int result = 0;
            for (int y = 0; y < N; y++) {
                int x = 0;
                while (table[x][y] != 1) {
                    if (table[x][y] == 2) {
                        result++;
                    }
                    x++;
                }
            }

            for (int y = 0; y < N; y++) {
                int x = 99;
                while (table[x][y] != 2) {
                    if (table[x][y] == 1) {
                        result++;
                    }
                    x--;
                }
            }

            System.out.println("#" + tc + " " + result);
        }
    }
}
