package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1463_1로만들기 {
    static Integer[] dp;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new Integer[N + 1];
        dp[0] = dp[1] = 0;

        System.out.println(recur(N));
    }

    static int recur(int num) {
        if (dp[num] == null) {

            if (num % 6 == 0) {
                dp[num] = Math.min(recur(num - 1), Math.min(recur(num / 3), recur(num / 2))) + 1;
            } else if (num % 3 == 0) {
                dp[num] = Math.min(recur(num / 3), recur(num - 1)) + 1;
            } else if (num % 2 == 0) {
                dp[num] = Math.min(recur(num / 2), recur(num - 1)) + 1;
            } else {
                dp[num] = recur(num - 1) + 1;
            }
        }
        return dp[num];
    }
}
