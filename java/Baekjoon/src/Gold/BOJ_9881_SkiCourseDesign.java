package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9881_SkiCourseDesign {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] hills = new int[1000];

        for (int i = 0; i < N; ++i) {
            hills[i] = Integer.parseInt(br.readLine());
        }
        int ans = 99999999;
        for (int i = 0; i <= 100 - 17; ++i) {
            // i ~ i+17 까지가 우리가 잡은 범위이다.
            int tmp = 0;
            for (int j = 0; j < N; ++j) {
                if (hills[j] < i)
                    tmp += (i - hills[j]) * (i - hills[j]);
                if (hills[j] > i + 17)
                    tmp += (hills[j] - i - 17) * (hills[j] - i - 17);
            }
            ans = Math.min(ans, tmp);
        }
        System.out.println(ans);
    }
}

// - 0 - 17, 1-18 , 2-19, 83-100 과 같이 크기가 17인 범위를 모두나눈 후, 각 범위마다 N개의 언덕을 순회하며
// 깎거나 쌓아본다.
