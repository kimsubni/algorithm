
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
}