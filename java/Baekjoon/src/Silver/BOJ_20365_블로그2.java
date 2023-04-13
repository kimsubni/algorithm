package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_20365_블로그2 {
    static int N;
    static String input;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        input = br.readLine();
        int Bn = 0;
        int Rn = 0;
        for (int i = 0; i < input.length(); ++i) {
            if (input.charAt(i) == 'B') {
                Bn++;
            } else if (input.charAt(i) == 'R') {
                Rn++;
            }
        }
        find(Bn, Rn, 'B', 'R');
        find(Rn, Bn, 'R', 'B');
        System.out.println(ans);

    }

    static void find(int Big, int Small, char big, char small) {
        boolean flag = false;
        int tmp = 1;
        if (input.charAt(0) == small) {
            flag = true;
        }
        for (int i = 0; i < N; ++i) {
            if (input.charAt(i) == small) {
                if (flag) {
                    flag = false;
                    tmp++;
                }
            }
            if (input.charAt(i) == big) {
                flag = true;
            }
        }
        ans = Math.min(tmp, ans);
    }
}
