import java.util.*;

class Solution {
    
    public String[] op = {"I", "D 1", "D -1"};
    
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minpq = new PriorityQueue<>();
        PriorityQueue<Integer> maxpq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (String x : operations) {
            if (x.contains(op[0])) {
                maxpq.add(Integer.parseInt(x.substring(2)));
                minpq.add(Integer.parseInt(x.substring(2)));
            } else if (!maxpq.isEmpty() && x.equals(op[2])) {
                maxpq.remove(minpq.poll());
            } else if (!minpq.isEmpty() && x.equals(op[1])) {
                minpq.remove(maxpq.poll());
            }
        }
        if (minpq.isEmpty() && maxpq.isEmpty()) {
            return new int[]{0, 0};
        }
        return new int[]{maxpq.peek(), minpq.peek()};
    }
}