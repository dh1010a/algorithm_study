import java.util.*;

class Solution {
    public int[][] board;
    public Map<Integer, List<Node>> map;
    public int answer, cardCnt;
    public boolean[] visitedCard;

    public int[] dx = {1, 0, -1, 0};
    public int[] dy = {0, 1, 0 , -1};

    public int solution(int[][] board, int r, int c) {
        this.board = board;
        cardCnt = 0;
        answer = Integer.MAX_VALUE;
        map = new HashMap<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != 0) {
                    if (map.containsKey(board[i][j])) {
                        map.get(board[i][j]).add(new Node(i, j, 0));
                    } else {
                        map.put(board[i][j], new ArrayList<>());
                        map.get(board[i][j]).add(new Node(i, j, 0));
                        cardCnt++;
                    }
                }
            }
        }
        visitedCard = new boolean[cardCnt + 1];
        dfs(new Node(r, c, 0), 0, 0);

        return answer;

    }

    public void dfs(Node now, int depth, int nowCnt) {
        if (depth == cardCnt) {
            answer = Math.min(answer, nowCnt);
            return;
        }

        for (int i = 1; i <= cardCnt; i++) {
            if (!visitedCard[i]) {
                List<Node> list = map.get(i);
                Node node1 = list.get(0);
                Node node2 = list.get(1);

                int dir1 = move(now, node1) + move(node1, node2) + 2;
                int dir2 = move(now, node2) + move(node2, node1) + 2;

                board[node1.x][node1.y] = 0;
                board[node2.x][node2.y] = 0;
                visitedCard[i] = true;
                if (dir1 > dir2) {
                    dfs(node1, depth + 1, nowCnt + dir2);
                } else {
                    dfs(node2, depth + 1, nowCnt + dir1);
                }

                board[node1.x][node1.y] = i;
                board[node2.x][node2.y] = i;
                visitedCard[i] = false;
            }
        }

    }

    public int move(Node start, Node dest) {
        Deque<Node> dq = new ArrayDeque<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        visited[start.x][start.y] = true;
        dq.add(start);

        while (!dq.isEmpty()) {
            Node now = dq.remove();

            if (now.x == dest.x && now.y == dest.y) {
                return now.cnt;
            }

            // 일반 이동
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (isRange(nx, ny) && !visited[nx][ny]) {
                    dq.add(new Node(nx, ny, now.cnt + 1));
                    visited[nx][ny] = true;
                }
            }

            // ctrl 이동
            for (int i = 0; i < 4; i++) {
                int nx = now.x;
                int ny = now.y;


                while (true) {
                    nx += dx[i];
                    ny += dy[i];
                    if (!isRange(nx, ny)) {
                        nx -= dx[i];
                        ny -= dy[i];
                        break;
                    }
                    if (board[nx][ny] != 0) {
                        break;
                    }
                }
                if (visited[nx][ny]) continue;
                dq.add(new Node(nx, ny, now.cnt + 1));
                visited[nx][ny] = true;
            }
        }
        return -1;
    }


    public boolean isRange(int x, int y) {
        return x >= 0 && x < board.length && y >= 0 && y < board[0].length;
    }

    public class Node{
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