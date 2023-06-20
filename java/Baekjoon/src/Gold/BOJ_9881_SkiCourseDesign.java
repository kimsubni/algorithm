package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9881_SkiCourseDesign {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] hills = new int[N];

        for (int i = 0; i < N; ++i) {
            hills[i] = Integer.parseInt(br.readLine());
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= 100 - 17; ++i) {
            // i ~ i+17 까지가 우리가 잡은 범위이다.
            int tmp = 0;
            for (int j = 0; j < N; ++j) {
                if (hills[j] < i)
                    tmp += (i - hills[j]) * (i - hills[j]);
                if (hills[j] > i + 17)
                    tmp += (hills[j] - i - 17) * (hills[j] - i - 17);
            }
            if (ans > tmp) {
                ans = tmp;
            }
            // ans = Math.min(ans, tmp);
        }
        System.out.println(ans);
    }
}