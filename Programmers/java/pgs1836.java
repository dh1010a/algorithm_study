import java.util.*;

class pgs1836 {
    char[][] board;
    int M, N, cardCnt;
    Map<Character, List<Node>> cardLocationInfoMap;
    List<Character> list;

    public String solution(int m, int n, String[] stringBoard) {
        String answer = "";
        board = new char[m][n];
        N = n;
        M = m;
        cardLocationInfoMap = new HashMap<>();
        cardCnt = 0;
        list = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = stringBoard[i].charAt(j);
                if (board[i][j] >= 'A' && board[i][j] <= 'Z') {
                    if (!cardLocationInfoMap.containsKey(board[i][j])) {
                        cardLocationInfoMap.put(board[i][j], new ArrayList<>());
                        list.add(board[i][j]);
                        cardCnt++;
                    }
                    cardLocationInfoMap.get(board[i][j]).add(new Node(i, j));
                }
            }
        }

        Collections.sort(list);
        int idx = 0;
        while(list.size() != 0){
            List<Node> nodes = cardLocationInfoMap.get(list.get(idx));
            if(canRemove(nodes.get(0), nodes.get(1), list.get(idx))) {
                char popped = list.remove(idx);
                answer += popped;
                board[nodes.get(0).x][nodes.get(0).y] = '.';
                board[nodes.get(1).x][nodes.get(1).y] = '.';
                idx = 0;
            }
            else{
                idx++;
                if(idx == list.size()){
                    return "IMPOSSIBLE";
                }
            }
        }

        return answer;
    }

    public boolean canRemove(Node node1, Node node2, char card) {
        if (node1.y < node2.y) {
            if (checkX(node1.x, node2.x, node2.y, card) && checkY(node1.y, node2.y, node1.x, card)) {
                return true;
            }
            if (checkX(node1.x, node2.x, node1.y, card) && checkY(node1.y, node2.y, node2.x, card)) {
                return true;
            }
        } else {
            if (checkX(node1.x, node2.x, node2.y, card) && checkY(node2.y, node1.y, node1.x, card)) {
                return true;
            }
            if (checkX(node1.x, node2.x, node1.y, card) && checkY(node2.y, node1.y, node2.x, card)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkX(int x1, int x2, int y, char card) {
        for (int i = x1; i <= x2; i++) {
            if (board[i][y] != '.' && board[i][y] != card) {
                return false;
            }
        }
        return true;
    }

    public boolean checkY(int y1, int y2, int x, char card) {
        for (int i = y1; i <= y2; i++) {
            if (board[x][i] != '.' && board[x][i] != card) {
                return false;
            }
        }
        return true;
    }



    public boolean isRange(int x, int y) {
        return x >= 0 && x < M && y >= 0 && y < N;
    }

    public class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}