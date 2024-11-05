import java.util.Scanner;

public class swea1289 {

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int tc = 1; tc <= T; tc++) {
            String str = sc.next();
            int answer = 0;

            int now = 0;
            int cursor = 0;
            while (cursor < str.length()) {
                if (now != str.charAt(cursor) - '0') {
                    now = str.charAt(cursor) - '0';
                    answer++;
                }
                while (cursor < str.length() && str.charAt(cursor) - '0' == now) {
                    cursor++;
                }
            }
            System.out.println("#" + tc + " " + answer);
        }
    }
}
