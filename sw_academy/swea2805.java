import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class swea2805 {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());  // 테스트 케이스 수를 읽음


        for(int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());  // 농장의 크기
            int[][] farm = new int[N][N];
            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                for (int j = 0; j < N; j++) {
                    farm[i][j] = str.charAt(j) - '0';
                }
            }

            int result = 0;
            int mid = N / 2;
            for (int x = 0; x < N; x++) {
                for (int y = Math.abs(x - mid); y < N - Math.abs(x - mid); y++) {
                    result += farm[x][y];
                }
            }

            System.out.println("#" + tc + " " + result);
        }
    }
}
