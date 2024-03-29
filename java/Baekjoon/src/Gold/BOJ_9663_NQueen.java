package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9663_NQueen {
    static int N;
    static int ans;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        nQueen(0);
        System.out.println(ans);

    }

    public static void nQueen(int d) {
        if (d == N) {
            ans++;
            return;
        }

        for (int i = 0; i < N; ++i) {
            arr[d] = i;
            // 지금 나는 d열의 i행에다가 퀸을 넣을거야.
            // 근데 d열 가능해?
            if (Possible(d)) {
                nQueen(d + 1);
            }
        }
    }

    public static boolean Possible(int c) {
        for (int i = 0; i < c; ++i) {
            if (arr[c] == arr[i]) {
                // 만약 이전에 퀸을 넣었을 때 0열의 1행에 넣었다면 i행의 1행에도 넣으면 안되지.
                return false;
            }
            // 대각선 찾기
            else if (Math.abs(c - i) == Math.abs(arr[c] - arr[i])) {
                return false;
            }
        }
        return true;
    }

}
