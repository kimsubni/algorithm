package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2156_포도주시식 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] wine = new int[N];
        int[] dp = new int[N];
        for (int i = 0; i < N; ++i) {
            wine[i] = Integer.parseInt(br.readLine());
        }
        int max = 0;
        dp[0] = wine[0];
        if (N >= 2) {
            dp[1] = dp[0] + wine[1];
        }

        if (N >= 3) {
            dp[2] = Math.max(Math.max(dp[1], dp[0] + wine[2]), wine[1] + wine[2]);
            for (int i = 3; i < N; ++i) {
                dp[i] = Math.max(Math.max(dp[i - 3] + wine[i - 1], dp[i - 2]) + wine[i], dp[i - 1]);
            }
        }

        for (int i = 0; i < N; ++i) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);

    }
}
