class Solution {
    int answer = Integer.MAX_VALUE;
    
    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        dfs(0, 0, begin, target, words, visited);
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
    
    public void dfs(int idx, int count, String begin, String target, 
             String[] words, boolean[] visited) {
        if(idx > words.length - 1) {
            return ;
        }
        if(begin.equals(target)) {
            answer = Math.min(answer, count);
        }
        for(int i = 0; i < words.length; i++) {
            if(visited[i] || !checkWord(begin, words[i]) || answer <= count) {
                continue;
            }
            visited[i] = true;
            dfs(i, count+1, words[i], target, words, visited);
            visited[i] = false;
        }   
    }
    
    public boolean checkWord(String a, String b) {
        int diff = 0;
        for(int i = 0; i < a.length(); i++) {
            if(a.charAt(i) != b.charAt(i)) diff++;
        }
        if (diff > 1) return false;
        return true;
    }
    
    
}