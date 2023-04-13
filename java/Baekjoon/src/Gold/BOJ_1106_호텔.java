package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1106_호텔 {
    static int C, N;

    static final int INF = 9999999;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int[] dp = new int[C + 101];
        Arrays.fill(dp, INF);
        dp[0] = 0;
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int customer = Integer.parseInt(st.nextToken());
            for (int j = customer; j < C + 101; ++j) {
                dp[j] = Math.min(dp[j], dp[j - customer] + cost);
            }
        }
        int ans = INF;
        for (int i = C; i < C + 101; ++i) {
            ans = Math.min(ans, dp[i]);
        }
        System.out.println(ans);

    }

}
