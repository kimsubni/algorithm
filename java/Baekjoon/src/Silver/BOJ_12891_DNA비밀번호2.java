package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12891_DNA비밀번호2 {
    static int S, P;
    static String str;
    static int[] arr;
    static int[] minho;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        S = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        str = br.readLine();
        arr = new int[4];
        minho = new int[4];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solution();
        System.out.println(ans);

    }

    private static void solution() {
        for (int i = 0; i < P; ++i) {
            if (str.charAt(i) == 'A') {
                minho[0]++;
            } else if (str.charAt(i) == 'C') {
                minho[1]++;
            } else if (str.charAt(i) == 'G') {
                minho[2]++;
            } else if (str.charAt(i) == 'T') {
                minho[3]++;
            }
        }
        if (check())
            ans++;
        int l = 0;
        int r = P;
        while (r < S) {
            if (str.charAt(l) == 'A') {
                minho[0]--;
            } else if (str.charAt(l) == 'C') {
                minho[1]--;
            } else if (str.charAt(l) == 'G') {
                minho[2]--;
            } else if (str.charAt(l) == 'T') {
                minho[3]--;
            }

            if (str.charAt(r) == 'A') {
                minho[0]++;
            } else if (str.charAt(r) == 'C') {
                minho[1]++;
            } else if (str.charAt(r) == 'G') {
                minho[2]++;
            } else if (str.charAt(r) == 'T') {
                minho[3]++;
            }

            if (check())
                ans++;
            l++;
            r++;

        }

    }

    static boolean check() {
        for (int i = 0; i < 4; ++i) {
            if (arr[i] > minho[i]) {
                return false;
            }
        }
        return true;
    }
}
