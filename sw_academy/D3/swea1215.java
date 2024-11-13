package D3;

import java.util.Scanner;

public class swea1215 {

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T=1;

        for(int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int result = 0;

            char[][] arr = new char[8][];
            for (int i = 0; i < 8; i++) {
                arr[i] = sc.next().toCharArray();
            }

            // 세로 회문 먼저
            for (int y = 0; y < 8; y++) {
                int start = 0;
                int end = start + N - 1;
                StringBuilder str = new StringBuilder();
                for (int i = start; i <= end; i++) {
                    str.append(arr[i][y]);
                }
                while (true) {
                    if (isReverseable(N, str.toString().toCharArray())) {
                        result++;
                    }
                    start++;
                    end++;
                    if (end >= 8) {
                        break;
                    }
                    str.deleteCharAt(0);
                    str.append(arr[end][y]);
                }
            }

            //가로 회문
            for (int x = 0; x < 8; x++) {
                int start = 0;
                int end = start + N - 1;
                StringBuilder str = new StringBuilder();
                for (int i = start; i <= end; i++) {
                    str.append(arr[x][i]);
                }
                while (true) {
                    if (isReverseable(N, str.toString().toCharArray())) {
                        result++;
                    }
                    start++;
                    end++;
                    if (end >= 8) {
                        break;
                    }
                    str.deleteCharAt(0);
                    str.append(arr[x][end]);
                }
            }

            System.out.println("#" + tc + " " + result);
        }
    }


    public static boolean isReverseable(int N, char[] arr) {
        int mid = N / 2;
        if (N % 2 == 0) {
            for (int i = mid; i < N; i++) {
                if (arr[N - i - 1] != arr[i]) {
                    return false;
                }
            }
        } else {
            for (int i = mid + 1; i < N; i++) {
                if (arr[N - i - 1] != arr[i]) {
                    return false;
                }
            }
        }
        return true;
    }
}
