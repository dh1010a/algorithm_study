import java.util.*;
import java.io.*;

class Solution
{
    static int[] num_arr;
    static int max = 0;

	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            String s = sc.next();
            int chance = sc.nextInt();

            num_arr = new int[s.length()];

            for (int i = 0 ; i < s.length(); i++) {
                num_arr[i] = Integer.parseInt(s.charAt(i) + "");
            }
            if (chance > num_arr.length) {
                chance = num_arr.length;
            }

            dfs(0, 0, chance);

            System.out.println("#" + test_case + " " + max);
            max = 0;
		}
	}

    public static void dfs(int start, int depth, int max_cnt) {
        if (depth == max_cnt) {
            int result = 0;
            for (int i = 0; i < num_arr.length; i++) {
                result += Math.pow(10, num_arr.length - i - 1) * num_arr[i];
            }
            max = Math.max(max, result);

            return;
        }

        for (int i = start; i < num_arr.length - 1; i++) {
            for (int j = i + 1; j < num_arr.length; j++) {
                swap(i, j);
                dfs(i, depth + 1, max_cnt);
                swap(i, j);
            }
        }
    }

    public static void swap(int i, int j) {
        int tmp = num_arr[i];
        num_arr[i] = num_arr[j];
        num_arr[j] = tmp;
    }
}