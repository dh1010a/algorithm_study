import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());

        dp = new int[N];
        arr = new int [N];

        int answer = 0;
        

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for (int x = 0; x < N; x++) {
            int i = 0;
            int j = N-1;
            while (i < j) {
                if (arr[i] + arr[j] == arr[x]) {
                    if (i != x && j != x) {
                        answer++;
                        break;
                    } else if (i == x) {
                        i++;
                    } else {
                        j--;
                    }
                } else if (arr[i] + arr[j] > arr[x]) {
                    j--;
                } else {
                    i++;
                }
            }
        }

        bw.write(answer + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

}