package D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class swea1225 {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T = 10;

        for(int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());

            Deque<Integer> dq = new ArrayDeque<>();
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for (int i = 0; i < 8; i++) {
                dq.add(Integer.parseInt(st.nextToken()));
            }

            boolean flag = true;

            while (flag) {
                for (int i = 1; i < 6; i++) {
                    int now = dq.remove();
                    if (now - i <= 0) {
                        dq.add(0);
                        flag = false;
                        break;
                    } else {
                        dq.add(now - i);
                    }
                }
            }

            String result = "";
            System.out.print("#" + tc + " ");
            for (int x : dq) {
                System.out.print(x + " ");
            }
            System.out.println();


        }
    }
}
