import java.util.*;

class pgs42890 {
    List<List<Integer>> answers;

    public int solution(String[][] relation) {
        answers = new ArrayList<>();
        for (int i = 1; i <= relation[0].length; i++) {
            dfs(relation, new ArrayList<>(), 0, i);
        }
        return answers.size();
    }

    public void dfs(String[][] relation, List<Integer> list, int now, int n) {
        if (list.size() == n) {
            // 유일성 검사
            Set<String> set = new HashSet<>();
            for(int i = 0; i < relation.length; i++) {
                String tmp = "";
                for (int x: list) {
                    tmp += relation[i][x];
                }
                set.add(tmp);
            }
            if (set.size() == relation.length) {
                // 최소성 검사
                boolean flag = true;
                for (List<Integer> answer : answers) {
                    int cnt = 0;
                    for (int x: list) {
                        if (answer.contains(x)) cnt++;
                    }
                    if (cnt == answer.size()) {
                        flag = false;
                    }
                }
                if (flag) {
                    answers.add(new ArrayList<>(list));
                }
            }
            return;
        }

        for (int i = now; i < relation[0].length; i++) {
            list.add(i);
            dfs(relation, list, i + 1, n);
            list.remove(list.size() - 1);
        }

    }
}