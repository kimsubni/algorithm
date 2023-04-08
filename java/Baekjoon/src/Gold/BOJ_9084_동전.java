package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9084_동전 {
    public static void main(String[] args) throws IOException {
        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t, n, m, coin;
        int[] coins, dp;
        t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            coins = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                coins[j] = Integer.parseInt(st.nextToken());
            }
            m = Integer.parseInt(br.readLine());

            // DP
            dp = new int[m + 1];
            dp[0] = 1;
            for (int j = 0; j < n; j++) {
                coin = coins[j];
                for (int k = coin; k <= m; k++) {
                    dp[k] += dp[k - coin];
                }
            }
            sb.append(dp[m]).append('\n');
        }

        System.out.println(sb);
    }
}
