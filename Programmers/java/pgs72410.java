import java.util.*;

class pgs72410 {
	public String solution(String new_id) {
		String answer = "";
		answer = new_id.toLowerCase();
		answer = answer.replaceAll("[^a-z0-9-_.]", "");
		while (answer.contains("..")) {
			answer = answer.replace("..", ".");
		}
		// 3단계 정규식
		// new_id = answer.replaceAll("[.]{2,}", ".");
		if (answer.charAt(0) == '.') {
			answer = answer.substring(1);
		}
		if (answer.length() > 0 && answer.charAt(answer.length() - 1) == '.') {
			answer = answer.substring(0, answer.length() - 1);
		}
		// 4단계 정규식
		// answer = answer.replaceAll("^[.]+|[.]+$", "");
		if (answer.length() == 0) answer = "a";
		// 5단계 정규식
		// answer = answer.replaceAll("^\\s$", "a");
		if (answer.length() > 15) {
			answer = answer.substring(0, 15);
			if (answer.charAt(answer.length() - 1) == '.') {
				answer = answer.substring(0, answer.length() - 1);
			}
		}
		// 6단계 정규식
		// answer = answer.replaceAll("^(.{15}).*", "$1");
		// answer = answer.replaceAll("[.]$", "");
		if (answer.length() == 1) {
			answer += String.valueOf(answer.charAt(0)) + String.valueOf(answer.charAt(0));
		} else if (answer.length() == 2) {
			answer += String.valueOf(answer.charAt(1));
		}


		return answer;
	}
}