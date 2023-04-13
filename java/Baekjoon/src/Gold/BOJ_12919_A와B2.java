package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_12919_A와B2 {
    static String S, T;

    static boolean flag;
    static StringBuffer sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        T = br.readLine();
        solution(T);

        if (flag) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    static void solution(String str) {
        if (str.length() == S.length()) {
            if (str.equals(S))
                flag = true;
            return;
        }
        if (str.charAt(0) == 'B') {
            solution(new StringBuffer(str.substring(1)).reverse().toString());
        }
        if (str.charAt(str.length() - 1) == 'A') {
            solution(str.substring(0, str.length() - 1));
        }

    }
}
