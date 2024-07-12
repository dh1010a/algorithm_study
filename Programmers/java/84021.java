import java.util.*;
class Solution {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static List<List<Node>> matrixBList;
    static List<List<Node>> matrixTList;
    static int size;
    static int answer;
    
    public int solution(int[][] game_board, int[][] table) {
        answer = 0;
        size = game_board.length;
        boolean[][] visitedB = new boolean[size][size];
        boolean[][] visitedT = new boolean[size][size];
        
        matrixTList = new ArrayList<>();
        matrixBList = new ArrayList<>();
        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (visitedB[i][j] == false && game_board[i][j] == 0) {
                    System.out.println("방문 x, y = " + i +" "+ j);
                    bfs(game_board, i, j, 0, visitedB, matrixBList);
                }
                if (visitedT[i][j] == false && table[i][j] == 1) {
                    bfs(table, i, j, 1, visitedT, matrixTList);
                }
            }
        }
        compare(matrixBList, matrixTList);
        
        return answer;
    }
    
    public void bfs(int[][] board, int x, int y, int flag, boolean[][] visited, List<List<Node>> matrix) {
        
        visited[x][y] = true;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        
        List<Node> list = new ArrayList<>();
        list.add(new Node(0, 0));
        
        while (!q.isEmpty()) {
            Node n = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = n.x + dx[i];
                int ny = n.y + dy[i];
                if (isRange(nx, ny) && board[nx][ny] == flag && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new Node(nx, ny));
                    list.add(new Node(nx - x, ny - y));
                }
            }
        }
        matrix.add(list);
    }
    
    
    
    public void compare(List<List<Node>> matrixBList, List<List<Node>> matrixTList){
        boolean[] visited = new boolean[matrixTList.size()];
        
        for (int i = 0; i < matrixBList.size(); i++) {
            for (int j = 0; j < matrixTList.size(); j++) {
                if (visited[j] || matrixBList.get(i).size() != matrixTList.get(j).size()) {
                    continue;
                }
                if (!visited[j] && isAble(matrixBList.get(i), matrixTList.get(j))) {
                    visited[j] = true;
                    answer += matrixBList.get(i).size();
                    break;
                }
            }
        }
    }
    
    public boolean isAble(List<Node> board, List<Node> table) {
        Collections.sort(board);
        for (int i = 0; i < 4; i++) {
            //오름차순 정렬. table은 회전할때마다 다시 정렬해줌.
            Collections.sort(table);
            
            int curr_x = table.get(0).x;
            int curr_y = table.get(0).y;
            
            //회전하면서 좌표가 바뀌기 때문에, 다시 (0,0) 기준으로 세팅
            for(int j=0; j<table.size(); j++){
                table.get(j).x -= curr_x;
                table.get(j).y -= curr_y;
            }
            
            boolean check = true;
            for(int j=0; j<board.size(); j++){
                if(board.get(j).x != table.get(j).x || board.get(j).y != table.get(j).y){
                    check = false;
                    break;
                }
            }
            if (check) 
                return true;
            else {
                 for(int j=0; j<table.size(); j++){
                    int temp = table.get(j).x;
                    table.get(j).x = table.get(j).y;
                    table.get(j).y = -temp;
                }
            }
        }
        return false;
    }
    
    
    public boolean isRange(int x, int y) {
        return x >= 0 && x < size && y >= 0 && y < size;
    }
    
    
    class Node implements Comparable<Node>{
        int x, y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
        
        @Override
        public int compareTo(Node o){
            int res = Integer.compare(this.x, o.x);
            if(res==0){
                res = Integer.compare(this.y, o.y);
            }
            return res;
        }
    }
}