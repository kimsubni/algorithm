package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2470_두용액 {
    static int N;
    static long[] liquid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        liquid = new long[N];
        for (int i = 0; i < N; ++i) {
            liquid[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(liquid);
        solution();
    }

    private static void solution() {
        int left = 0;
        int right = N - 1;

        long gap = Integer.MAX_VALUE;
        long ans1 = 0;
        long ans2 = 0;

        long temp;
        long sum;
        while (left < right) {
            sum = liquid[left] + liquid[right];
            temp = Math.abs(sum);
            if (temp < gap) {
                gap = temp;
                ans1 = liquid[left];
                ans2 = liquid[right];
            }
            if (sum > 0) {
                right--;
            } else {
                left++;
            }
        }
        System.out.println(ans1 + " " + ans2);
    }
}
