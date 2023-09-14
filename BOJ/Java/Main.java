import java.io.IOException;
import java.util.*;

public class Main {

    public int[][] map = {{ 0, 1, 0, 1, 0 },
    { 0, 0, 0, 0, 0 },
    { 0, 1, 0, 0, 1 },
    { 1, 0, 1, 0, 0 },
    { 0, 1, 1, 1, 0 }};
    public boolean[][] visited;
    public int[][] result;
    public static void main(String[] args) throws IOException {
        Recur(0, 0);
    }
    
    public void Recur(int x){
        visited[row][col] = true;
        result.append([row, col]);
        if (row == exit.row && col == exit.col){
            stack.push(new Location(row, col));
            return;
        }
        for (int i = 0; i < 4; i++){
            int dr = row + dy[i];
            int dc = col + dx[i];
            if (is_moveAble(dr, dc)){
                moveTo(dr, dc);
            }
        }
        visited[row][col] = false;
        stack.pop();
        return;
    }

}