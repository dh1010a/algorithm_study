class Solution {
    public int[] solution(int[] A) {
        int[] answer = new int[A.length];
        int[] cnt_arr = new int[A.length*2+1];
        //int[] visited = new int[A.length*2+1];
        for (int i: A) {
            cnt_arr[i]++;
        }
        for (int i = 0; i < A.length; i++) {
            int count = 0;
            for (int j = 1; j*j <= A[i]; j++) {
                if (A[i] % j == 0) {
                    count += cnt_arr[j];
                    if (A[i]/j != j) {
                        count += cnt_arr[A[i]/j];
                    }
                }
            }
            answer[i] = A.length - count;
        }

        return answer;
    }
}
