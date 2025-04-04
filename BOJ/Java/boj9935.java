import java.util.*;
import java.io.*;

public class boj9935 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		String bomb = br.readLine();
		int bomb_len = bomb.length();

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < str.length(); i++) {
			stack.push(str.charAt(i));

			if (stack.size() >= bomb_len) {
				boolean same = true;
				for (int j = 0; j < bomb_len; j++) {
					if (stack.get(stack.size() - bomb_len + j) != bomb.charAt(j)) {
						same = false;
						break;
					}
				}

				if (same) {
					for (int j = 0; j < bomb_len; j++) {
						stack.pop();
					}
				}
			}
		}

		StringBuilder answer = new StringBuilder();
		if (stack.isEmpty()) {
			answer = new StringBuilder("FRULA");
		} else {
			for (Character x : stack) {
				answer.append(x);
			}
		}
		System.out.println(answer);

	}

}