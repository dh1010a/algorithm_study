import java.util.*;

class pgs17680 {

	public int solution(int cacheSize, String[] cities) {
		Deque<String> cache = new ArrayDeque<>();
		int answer = 0;

		if (cacheSize == 0) {
			return cities.length * 5;
		}

		for (String city: cities) {
			city = city.toLowerCase();
			if (cache.contains(city)) {
				cache.remove(city);
				cache.add(city);
				answer++;
			} else {
				if (cache.size() == cacheSize) {
					cache.remove(0);
					cache.add(city);
				} else {
					cache.add(city);
				}
				answer += 5;
			}
		}

		return answer;
	}
}