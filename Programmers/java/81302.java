import java.util.*;
class Solution {
    int r, c;
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        r = places[0].length;
        c = places[0][0].length();
        for (int i = 0; i < places.length; i++) {
            answer[i] = solution(places[i]);
        }
        return answer;
    }
    
    public int solution(String[] places) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (places[i].charAt(j) == 'P' && !isManhattan(places, new Node(i, j))) {
                    return 0;
                }
            }
        }
        return 1;
    }
    
    public boolean isManhattan(String[] places, Node start) {
        Deque<Node> q = new ArrayDeque<>();
        q.addFirst(start);
        boolean[][] visited = new boolean[r][c];
        visited[start.x][start.y] = true;
        while (!q.isEmpty()) {
            Node now = q.pollLast();
            if (getDist(start, now) > 2) {
                return true;
            } else {
                if (places[now.x].charAt(now.y) == 'P' && getDist(start, now) != 0) {
                    return false;
                }
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (isRange(nx, ny, visited) && places[nx].charAt(ny) != 'X') {
                    visited[nx][ny] = true;
                    q.addFirst(new Node(nx, ny));
                }
            }
        }
        return true;
    }
    
    public int getDist(Node x, Node y) {
        return Math.abs(x.x - y.x) + Math.abs(x.y - y.y);
    }
    
    public boolean isRange(int x, int y, boolean[][] visited) {
        return x >= 0 && x < r && y >= 0 && y < c && !visited[x][y];
    }
    
    class Node{
        int x;
        int y;
        
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}