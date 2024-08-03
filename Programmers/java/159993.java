// import java.util.*;
// class Solution {
//     int[][] map;
//     int[] dx = new int[] {1, 0, -1, 0};
//     int[] dy = new int[] {0, 1, 0, -1};
//     boolean[][] visited;

//     public boolean isRange(int x, int y) {
//         return x >= 0 && x < map.length && y >= 0 && y < map[0].length && map[x][y] > 0 && !visited[x][y];
//     }
    
//     public int bfs(int[] start, int[] dest) {
//         Queue<int[]> queue = new LinkedList<>();
//         queue.add(start);
//         visited[start[0]][start[1]] = true;
//         while(!queue.isEmpty()) {
//             int[] tmp = queue.poll();
//             if(tmp[0] == dest[0] && tmp[1] == dest[1]) {
//                 return tmp[2];
//             }
//             for(int i = 0; i < 4; i++) {
//                 int nx = tmp[0] + dx[i];
//                 int ny = tmp[1] + dy[i];
//                 if(isRange(nx, ny)) {
//                     visited[nx][ny] = true;
//                     queue.add(new int[] {nx, ny, tmp[2] + 1});
//                 }
//             }
//         }
//         return -1;
//     }
    
//     public int solution(String[] maps) {
//         map = new int[maps.length][maps[0].length()];
//         int answer = -1;
//         visited = new boolean[maps.length][maps[0].length()];
//         int[] start = new int[3];
//         int[] lv = new int[3];
//         int[] end = new int[3];
//         for(int i = 0; i < maps.length; i++) {
//             for(int j = 0; j <maps[i].length(); j++) {
//                 if(maps[i].charAt(j) == 'O') map[i][j] = 1;
//                 else if (maps[i].charAt(j) == 'L') {
//                     lv[0] = i;
//                     lv[1] = j;
//                     map[i][j] = 1;
//                 } else if(maps[i].charAt(j) == 'S'){
//                     start[0] = i;
//                     start[1] = j;
//                     map[i][j] = 1;
//                 } else if(maps[i].charAt(j) == 'E'){
//                     map[i][j] = 1;
//                     end[0] = i;
//                     end[1] = j;
//                 }
//             }
//         }
//         answer = bfs(start, lv);
//         if(answer > -1) {
//             visited = new boolean[maps.length][maps[0].length()];
//             int tmp = bfs(lv, end);
//             if(tmp == -1) {
//                 answer = -1;
//             } else {
//                 answer += tmp;
//             }
//         }
        
        
//         return answer;
//     }
// }

import java.util.*;
class Solution {
    int r, c;
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    
    public int solution(String[] maps) {
        int d1, d2 = 0;
        r = maps.length;
        c = maps[0].length();
        
        Node start = null;
        Node exit = null;
        Node lv = null;
        
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                char tmp = maps[i].charAt(j);
                switch (tmp) {
                    case 'S':
                        start = new Node(i, j, 0);
                        break;
                    case 'L':
                        lv = new Node(i, j, 0); 
                        break;
                    case 'E':
                        exit = new Node(i, j, 0);
                        break;
                }
            }
        }
        d1 = bfs(maps, start, lv);
        d2 = bfs(maps, lv, exit);
        
        
        return d1 > 0 && d2 > 0 ? d1 + d2 : -1;
    }
    
    public int bfs(String[] maps, Node start, Node dest) {
        Deque<Node> deque = new ArrayDeque<>();
        deque.addFirst(start);
        boolean[][] visited = new boolean[r][c];
        while (!deque.isEmpty()) {
            Node now = deque.pollLast();
            if (now.x == dest.x && now.y == dest.y) {
                return now.d;
            }
            for (int i = 0; i < 4; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (isRange(nx, ny) && maps[nx].charAt(ny) != 'X' && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    deque.addFirst(new Node(nx, ny, now.d+1));
                }
            }
        }
        return -1;
    }
    
    public boolean isRange(int x, int y) {
        return x >= 0 && x < r && y >= 0 && y < c;
    }
    
    class Node{
        int x;
        int y;
        int d;
        
        public Node(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
}