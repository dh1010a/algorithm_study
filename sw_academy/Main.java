import java.util.*;
import java.io.*;

class Main{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T;
		T=10;

		for(int tc = 1; tc <= T; tc++)
		{
            int count = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), "");

            int[] arr = new int[100];
            for (int i = 0; i < 100; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);
            for (int i = 0; i < count; i++) {
                arr[0]++;
                arr[arr.length - 1]--;
                Arrays.sort(arr);
            }
            int result = arr[arr.length - 1] - arr[0];
            bw.write("#" + tc + " " + result + "\n");
		}
        bw.flush();
        bw.close();
        br.close();
	}
}