import java.util.*;

class Solution {
	public String solution(String[] participant, String[] completion) {
		Map<String, Integer> counter = new HashMap<>();

		for (String s : completion) {
			counter.compute(s, (k, v) -> (v == null) ? 1 : v + 1);
		}

		for (String s : participant) {
			if (!counter.containsKey(s) || counter.get(s) == 0) {
				return s;
			}

			counter.compute(s, (k, v) -> v - 1);
		}
		return null;
	}
}