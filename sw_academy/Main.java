import java.util.*;
import java.io.*;

class Main{
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T=1;

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
                int last = 0;
                for (int x = 0; x < N; x++) {
                    if (table[x][y] == 1) {
                        last = 1;
                    } else if (table[x][y] == 2) {

                        if (last == 1) {
                            result++;
                        }
                        last = 2;
                    }
                }
            }

            System.out.println("#" + tc + " " + result);
        }
    }
}