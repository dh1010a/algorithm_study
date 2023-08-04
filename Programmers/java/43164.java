import java.util.*;
class Solution {
    List<String> list = new ArrayList<>();
    boolean[] visited;
    public void dfs(String[][] tickets, String path, String key, int depth) {
        if(depth == visited.length) {
            list.add(path);
            return;
        }
        for(int i = 0; i < tickets.length; i++) {
            if(tickets[i][0].equals(key) && !visited[i]) {
                visited[i] = true;
                dfs(tickets, path + " " + tickets[i][1], tickets[i][1], depth + 1);
                visited[i] = false;
            }
        }
    }
    
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        dfs(tickets, "ICN", "ICN", 0);
        Collections.sort(list);
        System.out.print(list.size());
        return list.get(0).split(" ");
    }
}

//version 2

// import java.util.*;
// class Solution {
//     String result = "J";
//     boolean[] visited;
//     public void dfs(String[][] tickets, String path, String key, int depth) {
//         if(depth == visited.length) {
//             result = result.compareTo(path) > 0 ? path : result;
//             return;
//         }
//         for(int i = 0; i < tickets.length; i++) {
//             if(tickets[i][0].equals(key) && !visited[i]) {
//                 visited[i] = true;
//                 dfs(tickets, path + " " + tickets[i][1], tickets[i][1], depth + 1);
//                 visited[i] = false;
//             }
//         }
//     }
    
//     public String[] solution(String[][] tickets) {
//         visited = new boolean[tickets.length];
//         dfs(tickets, "ICN", "ICN", 0);
//         return result.split(" ");
//     }
// }