import java.io.*;
import java.util.*;

public class Main {

    static int[][] map;
    static int answer;
    static int N, M;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        answer = Integer.MIN_VALUE;
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), "");
            String str = st.nextToken();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        dfs(0, 0, 0, 0);
    
        bw.write(answer + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    public static void dfs(int x, int y, int num, int sum) {

        if (x == N-1 && y == M-1) {
            answer = Math.max(sum, answer);

            if (answer == 0) {
                answer = map[0][0];
            }
            return;
        }

        if (visited[x][y]) {
            toNext(x, y, num, sum);
        } else {
            visited[x][y] = true;
            num = num * 10 + map[x][y];
            
            //본인까지 자르기
            toNext(x, y, 0, sum + num);

            //아래 합쳐서 자르기
            int i, tmp = num;
            for (i = x + 1; i < N; i++) {
                if (visited[i][y]) {
                    break;
                }
                visited[i][y] = true;
                tmp = tmp * 10 + map[i][y];
                toNext(x, y, 0, sum + tmp);
            }

            for (int j = x + 1; j < i; j++) {
                visited[j][y] = false;
            }

            //오른쪽 합쳐서 자르기
            tmp = num;
            for (i = y + 1; i < M; i++) {
                if (visited[x][i]) {
                    break;
                }
                visited[x][i] = true;
                tmp = tmp * 10 + map[x][i];

                toNext(x, y + i - y, 0, sum + tmp);
            }
            
            for (int j = y + 1; j < i; j++) {
                visited[x][j] = false;
            }

            visited[x][y] = false;
        }

    }

    public static void toNext(int x, int y, int num, int sum) {
        if (isRange(x, y+1)) {
            dfs(x, y+1, num, sum);
        } else if (isRange(x+1, 0)){
            dfs(x+1, 0, num, sum);
        } else {
            dfs(N-1, M-1, num, sum);
        }
    }

    public static boolean isRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }


}