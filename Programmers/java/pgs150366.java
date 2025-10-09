import java.util.*;

class pgs150366 {

	String[][] grid = new String[51][51];
	List<String> answer = new ArrayList<>();
	List<List<Node>> merged;

	public String[] solution(String[] commands) {
		merged = new ArrayList<>();

		for (String[] x : grid) {
			Arrays.fill(x, "");
		}

		for (String command : commands) {
			if (command.startsWith("UPDATE")) {
				update(command);
			} else if (command.startsWith("MERGE")) {
				merge(command);
			} else if (command.startsWith("UNMERGE")) {
				unmerge(command);
			} else if (command.startsWith("PRINT")) {
				print(command);
			}

		}

		return answer.toArray(String[]::new);
	}

	public void print(String command) {
		String[] cmd = command.split(" ");
		int r = Integer.parseInt(cmd[1]);
		int c = Integer.parseInt(cmd[2]);

		answer.add(grid[r][c].isEmpty() ? "EMPTY" : grid[r][c]);
	}

	public void unmerge(String command) {
		String[] cmd = command.split(" ");
		int r = Integer.parseInt(cmd[1]);
		int c = Integer.parseInt(cmd[2]);

		Node node = new Node(r, c);

		String tmp = grid[node.r][node.c].isEmpty() ? "" : grid[node.r][node.c];

		int mergedIdx = getMergedIdx(node);
		if (mergedIdx > -1) {
			for (Node x : merged.get(mergedIdx)) {
				grid[x.r][x.c] = "";
			}
			merged.remove(mergedIdx);
		}

		grid[node.r][node.c] = tmp;

	}

	public void merge(String command) {
		String[] cmd = command.split(" ");
		int r1 = Integer.parseInt(cmd[1]);
		int c1 = Integer.parseInt(cmd[2]);

		int r2 = Integer.parseInt(cmd[3]);
		int c2 = Integer.parseInt(cmd[4]);

		Node node1 = new Node(r1, c1);
		Node node2 = new Node(r2, c2);

		if (r1 == r2 && c1 == c2) {
			return;
		}

		int merged1Idx = getMergedIdx(node1);
		int merged2Idx = getMergedIdx(node2);

		if (merged1Idx > -1 && merged1Idx == merged2Idx) {
			return;
		}

		String mergeValue = getMergeValue(node1, node2);

		if (merged1Idx > -1 && merged2Idx > -1) {
			List<Node> merge = new ArrayList<>();
			merge.addAll(merged.get(merged1Idx));
			merge.addAll(merged.get(merged2Idx));

			if (merged1Idx > merged2Idx) {
				merged.remove(merged1Idx);
				merged.remove(merged2Idx);
			} else {
				merged.remove(merged2Idx);
				merged.remove(merged1Idx);
			}
			merged.add(merge);


			for (Node node : merge) {
				grid[node.r][node.c] = mergeValue;
			}
		} else if (merged1Idx > -1 && merged2Idx == -1) {
			merged.get(merged1Idx).add(node2);

			if (mergeValue != null) {
				for (Node node : merged.get(merged1Idx)) {
					grid[node.r][node.c] = mergeValue;
				}
			}
		} else if (merged1Idx == -1 && merged2Idx > -1) {
			merged.get(merged2Idx).add(node1);

			for (Node node : merged.get(merged2Idx)) {
				grid[node.r][node.c] = mergeValue;
			}
		} else {
			List<Node> merge = new ArrayList<>();
			merge.add(node1);
			merge.add(node2);

			merged.add(merge);
			for (Node node : merge) {
				grid[node.r][node.c] = mergeValue;
			}
		}
	}

	public String getMergeValue(Node node1, Node node2) {
		if (!grid[node1.r][node1.c].isEmpty() && !grid[node2.r][node2.c].isEmpty()) {
			return grid[node1.r][node1.c];
		} else if (grid[node1.r][node1.c].isEmpty() && grid[node2.r][node2.c].isEmpty()) {
			return "";
		}

		return grid[node1.r][node1.c].isEmpty() ? grid[node2.r][node2.c] : grid[node1.r][node1.c];
	}

	public void update(String command) {
		String[] cmd = command.split(" ");
		if (cmd.length == 4) {
			int r = Integer.parseInt(cmd[1]);
			int c = Integer.parseInt(cmd[2]);

			Node node = new Node(r, c);

			int mergedIdx = getMergedIdx(node);
			if (mergedIdx > -1) {
				List<Node> merge = merged.get(mergedIdx);
				for (Node x : merge) {
					grid[x.r][x.c] = cmd[3];
				}
			} else {
				grid[node.r][node.c] = cmd[3];
			}
		} else {
			for (int i = 1; i < 51; i++) {
				for (int j = 1; j < 51; j++) {
					if (grid[i][j].equals(cmd[1])) {
						grid[i][j] = cmd[2];
					}
				}
			}
		}

	}

	public int getMergedIdx(Node node) {
		for (int i = 0; i < merged.size(); i++) {
			if (merged.get(i).contains(node)) {
				return i;
			}
		}
		return -1;
	}

	class Node {
		int r;
		int c;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) { // 동일한 객체 참조
				return true;
			}
			if (obj == null || getClass() != obj.getClass()) {
				return false;
			}
			Node node = (Node) obj; // 형변환
			return r == node.r && c == node.c;
		}

		@Override
		public int hashCode() {
			return Objects.hash(r, c);
		}
	}
}