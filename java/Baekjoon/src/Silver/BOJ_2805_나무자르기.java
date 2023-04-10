package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2805_나무자르기 {
    static int N;
    static long M;
    static long[] tree;
    static long ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Long.parseLong(st.nextToken());
        tree = new long[N];
        st = new StringTokenizer(br.readLine());
        ans = 0;
        for (int i = 0; i < N; ++i) {
            tree[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(tree);
        binarySearch();
        System.out.println(ans);
    }

    static void binarySearch() {
        long start = 1;
        long end = tree[N - 1];

        while (start <= end) {
            long mid = (start + end) / 2;
            long take = 0;
            for (int i = 0; i < N; ++i) {
                long now = (tree[i] - mid);
                if (now > 0) {
                    take += now;
                }
            }
            if (take >= M) {
                ans = Math.max(ans, mid);
                start = mid + 1;
            } else if (take < M) {
                end = mid - 1;
            }
        }
    }
}
