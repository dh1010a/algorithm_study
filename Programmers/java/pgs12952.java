class pgs12952 {

    static int answer = 0;
    static int[] vy = new int[13]; // 1~12

    public int solution(int n) {
        for(int i=1;i<=n;i++){
            go(1, i, n);
        }
        return answer;
    }

    public void go(int x, int y, int n){
        for(int i=1;i<x;i++){
            if(y == vy[i]) return;
            if(Math.abs(x - i) == Math.abs(y - vy[i])) return;
        }

        // 종료 조건
        if(x == n){
            answer++;
            return;
        }

        vy[x] = y; // x행의 y값 저장

        for(int i=1;i<=n;i++){
            go(x+1, i, n);
        }
    }
}