import java.io.*;
import java.util.*;

public class Main {
	static int N, K, map;
	static int[][] world;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, -0};
    static List<Node> snake = new ArrayList<>();
    static HashMap<Integer, String> map = new HashMap<>();
    


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        map = new int[N+1][N+1];


        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[r-1][c-1] = 1;
        }

        int L = Integer.parseInt(br.readLine());

        int time = 0;
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            while (true) {

            }
        }
		
        bw.write(answer + "\n");


        br.close();
        bw.flush();
        bw.close();
    }

}

class Node{
	int x;
	int y;

	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
