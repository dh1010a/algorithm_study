import java.util.*;

class Solution {
    
    Node[] nodeArr;
    
    public String solution(int n, int k, String[] cmd) {
        String answer = "";
        nodeArr = new Node[1000001];
        nodeArr[0] = new Node();
        for (i = 1; i < n; i++) {
            nodeArr[i] = new Node();
            nodeArr[i].prev = nodeArr[i-1];
            nodeArr[i-1].next = nodeArr[i];
        }
        return answer;
    }
    
    class Node {
        Node prev = null;
        Node next = null;
        boolean isDeleted;
    }
}