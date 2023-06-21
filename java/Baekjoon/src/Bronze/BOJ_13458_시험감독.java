package Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13458_시험감독 {

    static int N, B, C;
    static int[] A;
    static long ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        A = new int[N];
        for (int i = 0; i < N; ++i) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        ans = N;
        for (int i = 0; i < N; ++i) {
            A[i] -= B;
        }
        for (int i = 0; i < N; ++i) {
            if (A[i] > 0) {
                ans += (int) Math.ceil((double) A[i] / C);
            }
        }
        System.out.println(ans);
    }
}
