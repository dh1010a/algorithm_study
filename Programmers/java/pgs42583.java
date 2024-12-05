import java.util.*;
class pgs42583 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {

        Queue<Integer> bridge = new LinkedList<>();
        Queue<Integer> trucks = new LinkedList<>();
        int time = 0;
        int sum = 0;
        for (int i = 0; i < bridge_length; i++) {
            bridge.add(0);
        }
        for (int x: truck_weights) {
            trucks.add(x);
        }
        while (!trucks.isEmpty()) {
            time++;
            int tmp = 0;
            if (!bridge.isEmpty())
                tmp = bridge.poll();
            sum -= tmp;
            if (sum + trucks.peek() <= weight) {
                int now = trucks.poll();
                bridge.add(now);
                sum += now;
            } else {
                bridge.add(0);
            }
            
            
        }
        time += bridge_length;
        return time;
    }
}