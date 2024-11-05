import java.util.*;

class swea2806
{
    static int[] board;
    static int answer;

	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int tc = 1; tc <= T; tc++)
		{
            int N = sc.nextInt();
            board = new int[N];
            answer = 0;

            dfs(N, 0);
            System.out.println("#" + tc + " " + answer);
		}
	}

    public static void dfs(int N, int now) {
        if (now == N) {
            answer++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (isPossible(now, i)) {
                board[now] = i;
                dfs(N, now + 1);
            }
        }
    }

    public static boolean isPossible(int x, int y) {
        for (int i = 0; i < x; i++) {
            if (Math.abs(x - i) == Math.abs(y - board[i])) {
                return false;
            }
            if (board[i] == y) {
                return false;
            }
        }
        return true;
    }
    
}