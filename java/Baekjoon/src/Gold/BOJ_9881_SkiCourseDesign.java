package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_9881_SkiCourseDesign {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] hills = new int[N];

        for (int i = 0; i < N; ++i) {
            hills[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(hills);

        for (int i = 0; i < N; ++i) {

        }

    }
}
