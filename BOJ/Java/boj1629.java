import java.util.*;
import java.io.*;

public class boj1629 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int A = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken()), C = Integer.parseInt(st.nextToken());

		System.out.println(solve(A, B, C));
	}

	public static long solve(int A, int B, int C) {
		if (B == 0) {
			return 1;
		}

		long n = solve(A, B / 2, C);
		if (B % 2 == 0) {
			return n * n % C;
		} else {
			return (n * n % C) * A % C;
		}
	}
}