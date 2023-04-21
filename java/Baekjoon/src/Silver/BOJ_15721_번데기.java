
package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_15721_번데기 {

    static int a, t, n;
    static int repeat = 2;
    static int zeroCount, oneCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        a = Integer.parseInt(br.readLine());
        t = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());
        int result = solve();
        System.out.println(result);

    }

    public static int solve() {
        while (true) {
            for (int i = 0; i < 4; i++) {
                if (i % 2 == 0) {
                    zeroCount++;
                } else {
                    oneCount++;
                }
                if (n == 0 && zeroCount == t) {
                    return (zeroCount + oneCount - 1) % a;
                }
                if (n == 1 && oneCount == t) {
                    return (zeroCount + oneCount - 1) % a;
                }
            }
            for (int i = 0; i < repeat; i++) {
                zeroCount++;
                if (zeroCount == t && n == 0) {
                    return (zeroCount + oneCount - 1) % a;
                }
            }
            for (int i = 0; i < repeat; i++) {
                oneCount++;
                if (oneCount == t && n == 1) {
                    return (zeroCount + oneCount - 1) % a;
                }
            }
            repeat++;
        }
    }
}