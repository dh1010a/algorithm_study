import java.util.*;
class Solution {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static List<List<Node>> matrixBList;
    static List<List<Node>> matrixTList;
    static boolean[][] visitedB; 
    static boolean[][] visitedT;
    static int size;
    
    public int solution(int[][] game_board, int[][] table) {
        int answer = -1;
        size = game_board.length;
        visitedB = new boolean[size][size];
        visitedT = new boolean[size][size];
        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (visitedB[i][j] == false) {
                    bfs(table, i, j, 0, visitedB, matrixBList);
                }
                if (visitedT[i][j] == false) {
                    bfs(game_board, i, j, 0, visitedT, matrixBList);
                }
            }
        }
        
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
            x = n.x;
            y = n.y;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (isRange(nx, ny) && board[nx][ny] == flag && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new Node(nx, ny));
                    list.add(new Node(nx - i, ny - i));
                }
            }
        }
        matrix.add(list);
    }
    
    public boolean isRange(int x, int y) {
        return x >= 0 && x < size && y >= 0 && y < size;
    }
    
    class Matrix {
        List<List<Node>> poly = new ArrayList<>();
        
        public Matrix() {
        }
        
        public void add(List<Node> nodes) {
            poly.add(nodes);
        }
        
        public void makeRotate() {
            for (List<Node> arr : poly) {
                poly.add(swap180(arr));
                List<Node> tmp = rotate90(arr);
                poly.add(tmp);
                poly.add(swap180(tmp));
            }
        }
        
        
        
        public List<Node> rotate90(List<Node> nodes) {
            List<Node> list = new ArrayList<>();
            for(Node node: nodes) {
                int tmp = node.x;
                node.x = node.y;
                node.y = changeMark(tmp);
                list.add(node);
            }
            return list;
        }
        
        public List<Node> swap180(List<Node> nodes) {
            List<Node> tmp = new ArrayList<>();
            for(Node node: nodes) {
                node.x = changeMark(node.x);
                node.y = changeMark(node.y);
                tmp.add(node);
            }
            return tmp;
        }
        
        public int changeMark(int x) {
            return x < 0 ? Math.abs(x) : x * -1; 
        }
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