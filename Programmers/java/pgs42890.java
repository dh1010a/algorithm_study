import java.util.*;
class Solution {
    int answer, size;
    
    public int solution(String[][] relation) {
        answer = 0;
        size = relation[0].length;
        // 속성들의 인덱스 조합을 저장할 리스트
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            // 1개부터 n개까지, 속성의 조합을 구함
            dfs(relation, i, 0, list, new ArrayList<>());
        }
        
        
        return list.size();
    }
    
    public void dfs(String[][] relation, int n, int start, List<List<Integer>> list, List<Integer> now) {
        // now는 현재 만든 조합. n개를 모두 담았다면, 종료 조건이 충족
        if (n == now.size()) {
            // 저장한 속성의 유일성을 판단하기 위한 set
            Set<List<String>> set = new HashSet<>();
            // now에 들어있는 속성의 인덱스를 바탕으로, set에 속성의 값의 리스트를 넣음
            for (int i = 0; i < relation.length; i++) {
                List<String> tmp = new ArrayList<>();
                for (int x: now) {
                    tmp.add(relation[i][x]);
                }
                set.add(tmp);
            }
            // 넣은 속성의 값 중 중복되는 것이 있는지 확인
            if (set.size() == relation.length) {
                boolean flag = true;
                // 만약 중복되는 것이 없다면, 유일성을 충족한다.
                // 최소성을 검사하기 위해, 기존에 list에 저장해두었던 후보키를 확인하여 중복되는 속성의 갯수를 세고
                for (List<Integer> x : list) {
                    int cnt = 0;
                    for (int y : now) {
                        if (x.contains(y)) {
                            cnt++;
                        }
                    }

                    // 만약 기존 후보키에 있던 속성이 전부 새로 만든 조합의 속성에 들어있다면
                    if (cnt == x.size()) {
                        // 새로 만든 후보키 조합은 최소성을 만족하지 못한다.
                        flag = false;
                    }
                }
                if (flag) {
                    list.add(new ArrayList<>(now));
                }
            }
            return;
        }
        
        for (int i = start; i < size; i++) {
            now.add(i);
            dfs(relation, n, i+1, list, now);
            now.remove(now.size() - 1);
        }
    }
}