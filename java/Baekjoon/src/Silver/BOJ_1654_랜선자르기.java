package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1654_랜선자르기 {
    static int N, K;
    static int[] yungsik;
    static long answer;
    static long max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        yungsik = new int[K];
        max = 0;
        for (int i = 0; i < K; ++i) {
            yungsik[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, yungsik[i]);
        }
        answer = 0;
        binarySearch(1, max);
        System.out.println(answer);
    }

    private static void binarySearch(long start, long end) {
        if (start > end) {
            return;
        }
        long mid = (start + end) / 2;
        long cnt = 0;
        for (int i = 0; i < K; ++i) {
            cnt += yungsik[i] / mid;
        }
        if (cnt >= N) {
            answer = mid;
            binarySearch(mid + 1, end);
        } else if (cnt < N) {
            binarySearch(start, mid);
        }

    }
}
