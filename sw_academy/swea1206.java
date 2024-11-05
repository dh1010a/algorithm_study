import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=10;

		for(int tc = 1; tc <= T; tc++)
		{
            int apart_cnt = sc.nextInt();
            int[] apart = new int[apart_cnt];
            
            for (int i = 0; i < apart_cnt; i++) {
            	apart[i] = sc.nextInt();
            }
            int answer = 0;
            for (int i = 2; i < apart_cnt -2; i++) {
             	int max_h = Math.max(Math.max(apart[i-2], apart[i-1]), Math.max(apart[i+1], apart[i+2]));
                if (apart[i] > max_h) {
                    answer += apart[i] - max_h;
                }
            }
            System.out.println("#" + tc + " " + answer);

		}
	}
}