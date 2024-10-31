import java.util.*;

class Solution {
    
    private Node[] nodeArr;
    
    public String solution(int n, int k, String[] cmd) {
        nodeArr = new Node[1000001];
        nodeArr[0] = new Node();
        for (int i = 1; i < n; i++) {
            nodeArr[i] = new Node();
            nodeArr[i].prev = nodeArr[i-1];
            nodeArr[i-1].next = nodeArr[i];
        }
        
        Stack<Node> trash= new Stack<>();
        Node now = nodeArr[k];
        
        for (String query : cmd) {
            char type = query.charAt(0);
            if (type == 'U') {
                int cnt = Integer.parseInt(query.substring(2));
                for (int i = 0 ; i < cnt; i++)
                    now = now.prev;
            }
            else if (type == 'D') {
                int cnt = Integer.parseInt(query.substring(2));
                for (int i = 0 ; i < cnt; i++) {
                    now = now.next;
                }
            } else if (type == 'C') {
                now.isDeleted = true;
                trash.push(now);

                Node next = now.next;
                Node prev = now.prev;
                if (prev != null) {
                    prev.next = next;
                }
                if (next != null) {
                    next.prev = prev;
                    now = next;
                } else {
                    now = prev;
                }
            } else if(type == 'Z') {
                Node node = trash.pop();
                Node prev=node.prev;
                Node next=node.next;

                node.isDeleted=false;
                if(prev!=null){
                    prev.next=node;
                }
                if(next!=null){
                    next.prev=node;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            if(nodeArr[i].isDeleted) sb.append('X');
            else sb.append('O');
        }
        
        return sb.toString();
    }
    
    class Node {
        Node prev = null;
        Node next = null;
        boolean isDeleted;
    }
}