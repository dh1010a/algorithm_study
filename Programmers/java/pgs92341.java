import java.util.*;

class pgs92341 {
	public int[] solution(int[] fees, String[] records) {
		List<Integer> answer = new ArrayList<>();

		Map<String, List<History>> map = new HashMap<>();
		for (String x: records) {
			String[] str = x.split(" ");
			if (!map.containsKey(str[1])) {
				map.put(str[1], new ArrayList<>());
				map.get(str[1]).add(new History(str[0], ""));
			} else {
				if (str[2].equals("IN")) {
					map.get(str[1]).add(new History(str[0], ""));
				} else {
					map.get(str[1]).get(map.get(str[1]).size() - 1).out = str[0];
				}
			}
		}

		Map<String, Integer> feeMap = new TreeMap<>();

		for (Map.Entry<String, List<History>> x : map.entrySet()) {
			List<History> list = x.getValue();
			int time = 0;

			for (History h : list) {
				time += calTime(h.in, h.out);
			}
			feeMap.putIfAbsent(x.getKey(), 0);
			feeMap.put(x.getKey(), feeMap.get(x.getKey()) + time);
		}

		for (Map.Entry<String, Integer> x : feeMap.entrySet()) {
			int time = x.getValue();

			if (time <= fees[0]) {
				answer.add(fees[1]);
			} else {
				int spare = time - fees[0];
				double result = (double) spare / fees[2];
				answer.add(fees[1] + ((int) Math.ceil(result) * fees[3]));
			}
		}

		return answer.stream().mapToInt(i -> i).toArray();
	}

	public int calTime(String start, String end) {
		int startTime = Integer.parseInt(start.substring(0, 2)) * 60 + Integer.parseInt(start.substring(3, 5));
		int endTime = 0;
		if (end == null || end.isEmpty()) {
			endTime = 24 * 60 - 1;
		} else {
			endTime = Integer.parseInt(end.substring(0, 2)) * 60 + Integer.parseInt(end.substring(3, 5));
		}
		return endTime - startTime;
	}

	class History {
		String in;
		String out;

		public History(String in, String out) {
			this.in = in;
			this.out = out;
		}
	}
}