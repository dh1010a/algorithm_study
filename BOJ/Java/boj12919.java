import java.util.*;
import java.io.*;

public class boj12919 {

	static String S;
	static String T;

	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = br.readLine();
		T = br.readLine();

		find(T);

		System.out.println(answer);
	}

	public static void find(String now) {
		if (now.length() == S.length()) {
			if (now.equals(S)) {
				answer = 1;
			}
			return;
		}

		if (now.charAt(now.length() - 1) == 'A') {
			find(now.substring(0, now.length() - 1));
		}

		if (now.charAt(0) == 'B') {
			String str = new StringBuilder(now.substring(1)).reverse().toString();
			find(str);
		}
	}
}