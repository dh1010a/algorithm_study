import java.util.*;
class Solution {
    public List<Integer> list = new ArrayList<>();
    public boolean[] visited = new boolean[7];


    public int solution(String numbers) {
        int answer = 0;
        for (int i = 0; i < numbers.length(); i++) {
            dfs(numbers, "", i+1);
        }
        for (int x : list) {
            if (isPrimeNum(x)) {
                answer++;
            }
        }
        
        return answer;
    }

    public void dfs(String str, String temp, int length) {
        
        if (temp.length() == length) {
            int num = Integer.parseInt(temp);
            if (!list.contains(num)) {
                System.out.println(num);
                list.add(num);
            }
        }

        for (int i = 0; i < str.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                temp += str.charAt(i);
                dfs(str, temp, length);
                visited[i] = false;
                temp = temp.substring(0, temp.length()-1);
            }
        }
    }
    
    public boolean isPrimeNum(int x) {
        int i = 2;
        if (x < 2) return false;

        while (i * i <= x) {
            if (x % i == 0) {
                return false;
            }
            i++;
        }
        return true;
    }
}