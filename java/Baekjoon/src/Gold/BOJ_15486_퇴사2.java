package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15486_퇴사2 {
    static int N;

    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 2];
        dp[0] = 0;
        for (int i = 1; i < N + 1; ++i) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int money = Integer.parseInt(st.nextToken());
            dp[i] = Math.max(dp[i - 1], dp[i]);
            if (time + i <= N + 1)
                dp[time + i] = Math.max(dp[time + i], money + dp[i]);
        }
        int ans = 0;
        for (int i = 1; i < N + 2; ++i) {
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);
    }
}
