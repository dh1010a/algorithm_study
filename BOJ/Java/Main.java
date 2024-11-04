import java.util.*;
import java.io.*;

class Main {
    static boolean[][] visited;
    static int N, K, max;

	public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        max = -1;
        visited = new boolean[1000001][K + 1];

        dfs(N + "", 0);
        
        bw.write(max + "\n");
        bw.flush();
        bw.close();
        br.close();
	}

    public static void dfs(String numStr, int depth) {
        int num = Integer.parseInt(numStr);
        if (depth == K) {
            max = Math.max(num, max);
            return;
        }

        for (int i = 0; i < numStr.length() - 1; i++) {
            for (int j = i + 1; j < numStr.length(); j++) {
                int next = swap(numStr, i, j);
                if (next != -1 && !visited[next][depth]) {
                    visited[next][depth] = true;
                    dfs(next + "", depth + 1);
                }
            }
        }
        
    }



    public static int swap(String num, int i, int j) {
        char[] num_arr = num.toCharArray();

        // 바꾸면 앞자리가 0이 되는 경우 -1 리턴
        if (i == 0 && num_arr[j] == '0') {
            return -1;
        }

        char tmp = num_arr[i];
        num_arr[i] = num_arr[j];
        num_arr[j] = tmp;

        return Integer.parseInt(new String(num_arr));
    }

   
}