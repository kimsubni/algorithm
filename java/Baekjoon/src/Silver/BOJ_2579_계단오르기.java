package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2579_계단오르기 {
    static int N;
    static int[] step;
    static int max = 0;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        step = new int[N + 1];
        dp = new int[N + 1];
        for (int i = 1; i < N + 1; ++i) {
            step[i] = Integer.parseInt(br.readLine());
        }
        int max = 0;
        dp[0] = 0;
        dp[1] = step[1];
        if (N >= 2)
            dp[2] = step[1] + step[2];
        if (N >= 3)
            dp[3] = Math.max(step[1], step[2]) + step[3];

        for (int i = 4; i < N + 1; ++i) {
            dp[i] = Math.max(dp[i - 3] + step[i - 1], dp[i - 2]) + step[i];
        }
        System.out.println(dp[N]);
    }

}
