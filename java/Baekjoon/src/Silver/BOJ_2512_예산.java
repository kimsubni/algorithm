package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2512_예산 {
    static int N;
    static int[] budget;
    static long M;
    static int max;
    static long ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        budget = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; ++i) {
            budget[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, budget[i]);
        }
        ans = 0;
        M = Integer.parseInt(br.readLine());
        binarySearch();
        System.out.println(ans);
    }

    private static void binarySearch() {
        long start = 0;
        long end = max;

        while (start <= end) {
            long mid = (start + end) / 2;
            long sum = 0;
            for (int i = 0; i < N; ++i) {
                if (mid - budget[i] > 0) {
                    sum += budget[i];
                } else {
                    sum += mid;
                }
            }

            if (sum <= M) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
    }
}
