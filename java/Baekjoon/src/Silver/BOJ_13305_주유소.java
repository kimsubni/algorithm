package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_13305_주유소 {
    static int N;
    static long[] gas;
    static long[] road;
    static long ans;
    static long[] min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        road = new long[N - 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            road[i] = Long.parseLong(st.nextToken());
        }
        gas = new long[N];
        min = new long[N];
        st = new StringTokenizer(br.readLine());
        long minValue = Integer.MAX_VALUE;
        for (int i = 0; i < N; ++i) {
            gas[i] = Long.parseLong(st.nextToken());
            if (minValue > gas[i]) {
                minValue = gas[i];
            }
            min[i] = minValue;
        }
        ans = 0;
        // 계속 주유소 다음으로 탐색하면서 나보다 더 적은 주유소있으면 거기까지 갈 거리를 지금주유소에서 결제해야해.
        for (int i = 0; i < N - 1; ++i) {
            ans += min[i] * road[i];
        }

        System.out.println(ans);
    }
}
