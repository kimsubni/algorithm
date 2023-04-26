package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12847_꿀아르바이트 {
    static int N, M;
    static long[] salary;
    static long max = 0;
    static long my = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        salary = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; ++i) {
            salary[i] = Long.parseLong(st.nextToken());
        }

        mySalary();
        findMax();
        System.out.println(max);
    }

    private static void findMax() {
        int r = M;
        int l = 0;
        max = Math.max(max, my);
        while (r < N) {
            my += (salary[r] - salary[l]);
            max = Math.max(max, my);
            l++;
            r++;
        }
    }

    private static void mySalary() {
        for (int i = 0; i < M; ++i) {
            my += salary[i];
        }
    }
}
