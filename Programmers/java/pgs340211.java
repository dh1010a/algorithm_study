import java.util.*;

class pgs340211 {

	List<Robot> robots;
	int arriveCount;

	public int solution(int[][] points, int[][] routes) {
		int answer = 0;

		int N = routes.length;
		arriveCount = 0;

		robots = new ArrayList<>();

		for (int[] route : routes) {
			int[] start = new int[]{points[route[0] - 1][0], points[route[0] - 1][1]};

			List<int[]> destList = new ArrayList<>();
			for (int i = 1; i < route.length; i++) {
				destList.add(new int[]{points[route[i] - 1][0], points[route[i] - 1][1]});
			}

			Robot robot = new Robot(start, destList);
			robots.add(robot);
		}

		while (arriveCount < N) {
			int[][] map = new int[101][101];

			// 현재 위협 count
			for (Robot robot : robots) {
				if (!robot.isOut) {
					map[robot.now_x][robot.now_y]++;

				}
			}
			for (int i = 1; i < 101; i++) {
				for (int j = 0; j < 101; j++) {
					if (map[i][j] > 1) {
						answer++;
					}
				}
			}

			for (Robot robot : robots) {
				robot.move();
			}


		}



		return answer;
	}

	public class Robot {

		public int now_x;
		public int now_y;

		public List<int[]> destList;

		public boolean isOut;

		public Robot(int[] start, List<int[]> dest) {
			this.now_x = start[0];
			this.now_y = start[1];
			destList = new ArrayList<>();
			this.isOut = false;
			destList.addAll(dest);
		}

		public void move() {
			if (destList.isEmpty()) {
				if (!this.isOut) {
					this.isOut = true;
					arriveCount++;
					now_x = now_y = -1;
				}
				return;
			}
			if (this.now_x != this.destList.get(0)[0]) {
				this.now_x += this.now_x > this.destList.get(0)[0] ? -1 : 1;
			} else if (this.now_y != this.destList.get(0)[1]) {
				this.now_y += this.now_y > this.destList.get(0)[1] ? -1 : 1;
			}

			if (this.now_x == this.destList.get(0)[0] && this.now_y == this.destList.get(0)[1]) {
				destList.remove(0);
			}
		}
	}

}