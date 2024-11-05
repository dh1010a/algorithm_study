import java.util.*;

class swea5215 {

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int tc = 1; tc <= T; tc++)
		{
            int N = sc.nextInt();
            int limit = sc.nextInt();
            List<Food> foods = new ArrayList<>();
            foods.add(new Food(0, 0));
            for (int i = 0; i < N; i++) {
                int score = sc.nextInt();
                int kcal = sc.nextInt();

                foods.add(new Food(score, kcal));
            }

            int[][] dp = new int[N + 1][limit + 1];
            for (int i = 1; i <= N; i++) {
                for (int j = 0; j <= limit; j++) {
                    if (j < foods.get(i).kcal) {
                        dp[i][j] = dp[i-1][j];
                    } else {
                        dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - foods.get(i).kcal] + foods.get(i).score);
                    }
                }
            }
            System.out.println("#" + tc + " " + dp[N][limit]);

		}
	}

    public static class Food{
        public int score;
        public int kcal;

        public Food(int score, int kcal) {
            this.score = score;
            this.kcal = kcal;
        }
    }
}