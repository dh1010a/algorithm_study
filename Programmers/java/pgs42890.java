import java.util.*;

class pgs42890 {

    List<Integer> selectedKey;
    List<List<Integer>> candidate;

    public int solution(String[][] relation) {
        selectedKey = new ArrayList<>();
        candidate = new ArrayList<>();
        for (int i = 1; i < relation.length; i++) {
            makeComb(relation, 0, i);
        }

        return candidate.size();
    }

    public void makeComb(String[][] relation, int start, int n) {
        if (selectedKey.size() == n) {
            if(checkUniq(relation) && checkMin(relation)) {
                List<Integer> answer = new ArrayList<>();
                answer.addAll(selectedKey);
                candidate.add(answer);
            }
            return;
        }

        for (int i = start; i < relation[0].length; i++) {
            selectedKey.add(i);
            makeComb(relation, i + 1, n);
            selectedKey.remove(selectedKey.size() - 1);
        }
    }

    public boolean checkUniq(String[][] relation) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < relation.length; i++) {
            String tmp = "";
            for (int x : selectedKey) {
                tmp += relation[i][x];
            }
            set.add(tmp);
        }
        if (set.size() != relation.length) {
            return false;
        }

        return true;
    }

    public boolean checkMin(String[][] relation) {
        for (List<Integer> x : candidate) {
            int cnt = 0;
            for (int i : selectedKey) {
                if (x.contains(i)) {
                    cnt++;
                }
            }
            if (cnt == x.size()) {
                return false;
            }
        }
        return true;
    }


}