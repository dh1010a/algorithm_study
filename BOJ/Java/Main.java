import java.io.*;
import java.util.*;

public class Main {
	static int N, K;
	static int[][] world;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static Deque<int[]> snake = new ArrayDeque<>();
    static Map<Integer, String> info = new HashMap<>();
    


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        world = new int[N+1][N+1];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            world[r][c] = 1;
        }
        snake.add(new int[]{1, 1});

        int L = Integer.parseInt(br.readLine());

        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            String d = st.nextToken();

            info.put(x, d);
        }

        int time = 0;
        int now_d = 0;
        while(true) {
            time++;

            int[] now = snake.peek();
            int[] nnow = new int[]{now[0] + dx[now_d], now[1] + dy[now_d]};


            if (!isRange(nnow) || isDead(nnow)) {
                break;
            }
            snake.addFirst(nnow);
            
            if (world[nnow[0]][nnow[1]] == 1) {
                world[nnow[0]][nnow[1]] = 0;
            } else {
                int[] tmp = snake.pollLast();
            }

            if (info.containsKey(time)) {
                now_d = changeD(now_d, info.get(time));
            }
            
        }

        bw.write(time + "\n");


        br.close();
        bw.flush();
        bw.close();
    }

    public static boolean isDead(int[] now) {
        for (int[] x : snake) {
            if (x[0] == now[0] && x[1] == now[1]) {
                return true;
            }
        }
        return false;
    }

    public static boolean isRange(int[] now) {
        return now[0] > 0 && now[0] <= N && now[1] > 0 && now[1] <= N;
    }

    public static int changeD(int d, String x) {
        if (x.equals("L")) {
            return (4 + (d - 1)) % 4;
        } else {
            return (d + 1) % 4;
        }
    }

}



