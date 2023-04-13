package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_20300_서강근육맨 {
    static int N;
    static long[] loss;
    static long ans;
    static long max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        loss = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; ++i) {
            loss[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(loss);
        if (N % 2 == 1) {
            max = loss[N - 1];
            N = N - 1;
        }
        for (int i = 0; i < N; ++i) {
            if (max < loss[i] + loss[N - i - 1]) {
                max = loss[i] + loss[N - i - 1];
            }
        }
        System.out.println(max);
    }
}
