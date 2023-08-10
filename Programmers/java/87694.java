import java.util.*;
class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = Integer.MAX_VALUE;
        Boolean[][] map = new Boolean[102][102];
        int[] dx = new int[] {1, 0, -1, 0};
        int[] dy = new int[] {0, 1, 0, -1};
        characterX *= 2;
        characterY *= 2;
        itemX *= 2;
        itemY *= 2;
        for(int i = 0; i < rectangle.length; i++) {
            int[] tmp = rectangle[i];
            for(int j = 0; j < tmp.length; j++) tmp[j] *= 2;
            
            for(int x = tmp[0]; x <= tmp[2]; x++) {
                for(int y = tmp[1]; y <= tmp[3]; y++) {
                    if(map[x][y] != Boolean.FALSE) {
                        map[x][y] = (x == tmp[0] || x == tmp[2] || 
                            y == tmp[1] || y == tmp[3]);
                    }
                }
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        map[characterX][characterY] = Boolean.FALSE;
        queue.add(new int[] {characterX, characterY, 0});
        while(!queue.isEmpty()) {
            int[] tmp = queue.poll();
            if(tmp[0] == itemX && tmp[1] == itemY) {
                answer = Math.min(answer, tmp[2]/2);
            }
            
            for(int i = 0; i < 4; i++) {
                int nx = tmp[0] + dx[i];
                int ny = tmp[1] + dy[i];
                if(isRange(map, nx, ny)) {
                    map[nx][ny] = Boolean.FALSE;
                    queue.add(new int[] {nx, ny, tmp[2]+1});
                }
            }
        }
        
        return answer;
    }
    
    public boolean isRange(Boolean[][] map, int x, int y) {
        return x >= 2 && x <= 100 && y >= 2 && y <= 100 && map[x][y] == Boolean.TRUE;
    }
}