import java.io.*;
import java.util.*;

public class Main {
    static List<Node> start = new ArrayList<>();
    static List<Node> dest = new ArrayList<>();
    static boolean[] visitedCustomer;
    static int[][] map;
    static int N, M, Fuel;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Fuel = Integer.parseInt(st.nextToken());
        visitedCustomer = new boolean[M];

        map = new int[N+1][N+1];
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine(), " ");
        Node taxi = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);

        // List<Node> start = new ArrayList<>(); 
        // List<Node> dest = new ArrayList<>(); 
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            start.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),0));
            dest.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),0));
        }
        
        bw.write(solution(taxi) + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    static int solution(Node taxi) {
        int cnt = 0;
        while (cnt < M) {
            int[] customer = getShortest(taxi);
            if (customer[1] > Fuel || customer[0] < 0) {
                return -1;
            }
            visitedCustomer[customer[0]] = true;
            Fuel -= customer[1];
            taxi.x = start.get(customer[0]).x;
            taxi.y = start.get(customer[0]).y;
            taxi.dist = 0;

            int result = moveToDest(taxi, customer[0]);
            if (result < 0) {
                return -1;
            }
            if (cnt < M) {
                Fuel += result;
            }
            taxi.x = dest.get(customer[0]).x;
            taxi.y = dest.get(customer[0]).y;
            taxi.dist = 0;

            cnt++;
        }
        return Fuel;

    }

    static int[] getShortest(Node taxi) {
        Deque<Node> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N+1][N+1];
        q.addFirst(taxi);
        visited[taxi.x][taxi.y] = true;

        List<Integer> idxList = new ArrayList<>();
        int nowMin = 10000;
        while (!q.isEmpty()) {
            Node now = q.pollLast();
            int idx = getCustomer(now);
            if (now.dist > nowMin) {
                break;
            }
            if (idx >= 0) {
                idxList.add(idx);
                nowMin = now.dist;
            }
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (isRange(nx, ny) && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.addFirst(new Node(nx, ny, now.dist + 1));
                }
            }
        }
        Node tmp = new Node(N * N, N * N, 100);
        int minIdx = -1;
        for (int i = 0; i < idxList.size(); i++) {
            Node now = start.get(idxList.get(i));
            if (tmp.x >= now.x) {
                if (tmp.x == now.x) {
                    if (tmp.y > now.y)  {
                        minIdx = idxList.get(i);
                        tmp = now;
                    }
                } else {
                    tmp = now;
                    minIdx = idxList.get(i);
                }
            }
        }
        
        return new int[]{minIdx, nowMin};
    }

    static int moveToDest(Node taxi, int idx) {
        Deque<Node> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N+1][N+1];
        q.addFirst(taxi);
        visited[taxi.x][taxi.y] = true;
        Node destination = dest.get(idx);

        while (!q.isEmpty()) {
            Node now = q.pollLast();
            if (now.x == destination.x && now.y == destination.y) {
                if (now.dist > Fuel) {
                    return -1;
                }
                return now.dist;
            }
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (isRange(nx, ny) && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.addFirst(new Node(nx, ny, now.dist + 1));
                }
            }
        }
        return -1;
    }

    static int getCustomer(Node now) {
        for (int i = 0; i < M; i++) {
            if (!visitedCustomer[i]) {
                Node tmp = start.get(i);
                if (tmp.x == now.x && tmp.y == now.y) {
                    return i;
                }
            }
        }
        return -1;
    }

    static boolean isRange(int x, int y) {
        return x > 0 && x <= N && y > 0 && y <= N && map[x][y] == 0;
    }

    static class Node {
        int x;
        int y;
        int dist;
        
        public Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

}
