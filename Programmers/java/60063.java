import java.util.*;
class Solution {
    int len;
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    
    public int solution(int[][] board) {
        int[] robot = {0, 0, 0, 1, 0};

        len = board.length;
        boolean[][][][] visited = new boolean[len][len][len][len];
        
        visited[0][0][0][1] = true;
        visited[0][1][0][0] = true;
        Deque<int[]> q = new ArrayDeque<>();
        q.addFirst(robot);
        while (!q.isEmpty()) {
            int[] now = q.pollLast();
            
            int x1 = now[0], y1 = now[1], x2 = now[2], y2 = now[3];
            int cnt = now[4];
            
            if ((x1 == len-1 && y1 == len-1) || (x2 == len-1 && y2 == len-1)) {
                return cnt;
            }
            
            for (int[] arr : getNext(board, now)) {
                if (!visited[arr[0]][arr[1]][arr[2]][arr[3]]) {
                    visited[arr[0]][arr[1]][arr[2]][arr[3]] = visited[arr[2]][arr[3]][arr[0]][arr[1]] = true;
                    q.addFirst(new int[]{arr[0], arr[1], arr[2], arr[3], arr[4]});
                }
            }
            
        }
        return -1;
    }
    
    
    public List<int[]> getNext(int[][] board, int[] now) {
        int x1 = now[0], y1 = now[1], x2 = now[2], y2 = now[3];
        int cnt = now[4];
        int d = 0;
        List<int[]> list = new ArrayList<>();
        
        if (y1 == y2) d = 1;
        
        for (int i = 0; i < 4; i++) {
            int nx1 = now[0] + dx[i], ny1 = now[1] + dy[i], nx2 = now[2] + dx[i], ny2 = now[3] + dy[i];
            if (isRange(board, nx1, ny1) && isRange(board, nx2, ny2)) {
                list.add(new int[]{nx1, ny1, nx2, ny2, cnt+1});
            }
        }
        if (d == 0) {
            if (isRange(board, x1+1, y1) && isRange(board, x2+1, y2)) {
                list.add(new int[]{x1, y1, x1+1, y1, cnt+1});
                list.add(new int[]{x2 + 1, y2, x2, y2, cnt+1});
            }
            if (isRange(board, x1-1, y1) && isRange(board, x2-1, y2)) {
                list.add(new int[]{x1, y1, x1-1, y1, cnt+1});
                list.add(new int[]{x2-1, y2, x2, y2, cnt+1});
            }
        } else {
            if (isRange(board, x1, y1+1) && isRange(board, x2, y2+1)) {
                list.add(new int[]{x1, y1, x1, y1 + 1, cnt+1});
                list.add(new int[]{x2, y2 + 1, x2, y2, cnt+1});
            }
            if (isRange(board, x1, y1-1) && isRange(board, x2, y2-1)) {
                list.add(new int[]{x1, y1, x1, y1-1, cnt+1});
                list.add(new int[]{x2, y2 - 1, x2, y2, cnt+1});
            }
        }
        return list;
    }
    
    
    public boolean isRange(int[][] board, int x, int y) {
        return x >= 0 && x < len && y >=0 && y < len && board[x][y] != 1;
    }
}