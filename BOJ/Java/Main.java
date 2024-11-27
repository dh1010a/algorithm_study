import java.util.*;
import java.io.*;

class Main {
    static int[][] map;
    static int N, M, fuel;
    static Node taxi;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static List<Node[]> list;
    static boolean[] visitedCustomer;

	public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        fuel = Integer.parseInt(st.nextToken());

        map = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        visitedCustomer = new boolean[M];
        list = new ArrayList<>();
        taxi = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            Node[] customers = new Node[2];
            customers[0] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
            customers[1] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
            list.add(customers);
        }

        int cnt = 0;
        int answer = -1;
        while (cnt < M) {
            int[] customerInfo = getCloseCustomer();

            // 여기서 한참 헤맴
            if (customerInfo[1] > fuel || customerInfo[0] < 0) {
                answer = -1;
                break;
            }
            visitedCustomer[customerInfo[0]] = true;
            fuel -= customerInfo[1];
            int dist = move(customerInfo);
            if (dist < 0) {
                answer = -1;
                break;
            }
            answer = fuel;
            cnt++;
        }

        System.out.println(answer);
        
        br.close();
	}

    public static int move(int[] customerInfo) {
        Deque<Node> dq = new ArrayDeque<>();
        boolean[][] visited = new boolean[N+1][N+1];

        Node start = list.get(customerInfo[0])[0];
        Node dest = list.get(customerInfo[0])[1];

        dq.add(start);
        visited[start.x][start.y] = true;
        while (!dq.isEmpty()) {
            Node now = dq.remove();

            if (now.x == dest.x && now.y == dest.y) {
                if (now.cnt > fuel) {
                    return -1;
                }
                fuel += now.cnt;
                taxi.x = now.x;
                taxi.y = now.y;
                return now.cnt;
            }
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (isRange(nx, ny) && !visited[nx][ny]) {
                    dq.add(new Node(nx, ny, now.cnt + 1));
                    visited[nx][ny] = true;
                }
            }
        }
        return -1;
    }

    public static int[] getCloseCustomer() {
        Deque<Node> dq = new ArrayDeque<>();
        boolean[][] visited = new boolean[N+1][N+1];

        int minDist = 10000;
        dq.add(taxi);
        visited[taxi.x][taxi.y] = true;
        List<Integer> idxList = new ArrayList<>();
        while (!dq.isEmpty()) {
            Node now = dq.remove();
            if (now.cnt > minDist) {
                break;
            }
            int customer = getCustomerNumber(now);
            if (customer > -1) {
                idxList.add(customer);
                minDist = now.cnt;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (isRange(nx, ny) && !visited[nx][ny]) {
                    dq.add(new Node(nx, ny, now.cnt + 1));
                    visited[nx][ny] = true;
                }
            }
        }

        int minIdx = -1;
        Node tmp = new Node(N * N, N * N, 100000);
        for (int i = 0; i < idxList.size(); i++) {
            Node[] customer = list.get(idxList.get(i));
            if (tmp.x >= customer[0].x) {
                if (tmp.x == customer[0].x) {
                    if (tmp.y > customer[0].y) {
                        tmp = customer[0];
                        minIdx = idxList.get(i);
                    }
                } else {
                    tmp = customer[0];
                    minIdx = idxList.get(i);
                }
            }
        }
        return new int[]{minIdx, minDist};
    }

    public static int getCustomerNumber(Node now) {
        for (int i = 0; i < M; i++) {
            if (!visitedCustomer[i]) {
                Node[] customer = list.get(i);
                if (now.x == customer[0].x && now.y == customer[0].y) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static boolean isRange(int x, int y) {
        return x > 0 && x <= N && y > 0 && y <= N && map[x][y] == 0;
    }



    public static class Node{
        int x;
        int y;
        int cnt;

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

}
