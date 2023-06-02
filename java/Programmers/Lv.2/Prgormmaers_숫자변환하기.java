import java.util.*;

public class Prgormmaers_숫자변환하기 {
    static final int INF = Integer.MAX_VALUE;
    static int answer = INF;
    static int[] dp;

    public int solution(int x, int y, int n) {

        dp = new int[1000001];
        Arrays.fill(dp, INF);
        recur(x, y, n, 0);
        int val = y;

        if (answer == INF)
            answer = -1;
        return answer;
    }

    static void recur(int x, int y, int n, int cnt) {
        if (cnt > dp[y]) {
            return;
        }
        dp[y] = cnt;
        if (x == y) {
            answer = dp[y];
            return;
        }
        if (y < x || dp[y] >= answer) {
            return;
        }
        if (y % 3 == 0) {
            recur(x, y / 3, n, dp[y] + 1);
        }
        if (y % 2 == 0) {
            recur(x, y / 2, n, dp[y] + 1);
        }
        if (y - n > 0) {
            recur(x, y - n, n, dp[y] + 1);
        }
    }

    public int solution2(int x, int y, int n) {
        int[] dp = new int[3000003];
        int INF = 1000002;

        Arrays.fill(dp, INF);
        dp[x] = -1;
        dp[y] = 0;
        for (int num = Math.max(y - n, Math.max(y / 2, y / 3)); num >= x; num--) {
            System.out.println(num);
            dp[num] = Math.min(dp[num + n] + 1, Math.min(dp[num * 2] + 1, dp[num * 3] + 1));
        }
        return dp[x] >= INF ? -1 : dp[x];
    }
}