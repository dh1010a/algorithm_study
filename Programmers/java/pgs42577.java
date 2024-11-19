import java.util.*;

class pgs42577 {
    public boolean solution(String[] phone_book) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String x: phone_book) {
            map.put(x, 1);
        }

        for (String x: phone_book) {
            for (int i = 1; i < x.length(); i++) {
                if (map.containsKey(x.substring(0, i))) {
                    return false;
                }
            }
        }

        return true;
    }
}