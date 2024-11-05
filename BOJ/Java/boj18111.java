import java.io.*;
import java.util.*;

public class Main {
	static int N, M, B;
	static int[][] world;
	static List<Result> results;
	static int MAX_HEIGHT = 256;
	static int minh, maxh;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

		world = new int[N][M];
		results = new ArrayList<>();
		maxh = 0;
		minh = 256;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				world[i][j] = Integer.parseInt(st.nextToken());
				maxh = Math.max(maxh, world[i][j]);
				minh = Math.min(minh, world[i][j]);
			}
		}

		calcurate();
		
		int minTime = Integer.MAX_VALUE;
		int maxHeight = 0;
		for (Result result : results) {
			if (result.time < minTime) {
				minTime = result.time;
				maxHeight = result.height;
			} else if (result.time == minTime) {
				maxHeight = Math.max(maxHeight, result.height);
			}
		}

		if (minTime == Integer.MAX_VALUE) {
			minTime = 0;
		}
		if (minh == maxh) {
			maxHeight = minh;
		}

		bw.write(minTime + " " + maxHeight + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

	public static void calcurate() {
		for (int h = minh; h <= maxh; h++) {
			int currentBlock = B;
			int time = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (world[i][j] > h) {
						currentBlock += (world[i][j] - h);
						time += (world[i][j] - h)*2;
					}
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (world[i][j] < h) {
						if (isPuttable(h - world[i][j], currentBlock)) {
							currentBlock -= (h - world[i][j]);
							time += h - world[i][j];
						} else {
							time = -1;
							break;
						}
					}
				}
				if (time < 0) {
					time = 0;
					break;
				}
			}
			if (time > 0) {
				results.add(new Result(time,h));
			}
		}
		
	}

	public static boolean isPuttable(int x, int y) {
		return x <= y && y > 0;
	}
}

class Result{
	int time;
	int height;

	public Result(int time, int height) {
		this.time = time;
		this.height = height;
	}
}