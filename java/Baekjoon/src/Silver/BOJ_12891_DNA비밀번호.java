package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_12891_DNA비밀번호 {
    static int S, P;
    static String DNA;
    static int[] ACGT;
    static Map<Character, Integer> minho;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        S = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        DNA = br.readLine();
        ACGT = new int[4];
        minho = new HashMap<>();
        minho.put('A', 0);
        minho.put('C', 0);
        minho.put('G', 0);
        minho.put('T', 0);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; ++i) {
            ACGT[i] = Integer.parseInt(st.nextToken());
        }

        solution();
        System.out.println(ans);

    }

    private static void solution() {
        for (int i = 0; i < P; ++i) {
            minho.put(DNA.charAt(i), minho.get(DNA.charAt(i)) + 1);
        }
        for (int i = 0; i < S - P + 1; ++i) {
            if (minho.get('A') >= ACGT[0] &&
                    minho.get('C') >= ACGT[1] &&
                    minho.get('G') >= ACGT[2] &&
                    minho.get('T') >= ACGT[3]) {
                ans++;
            }
            if (i + P < S) {
                minho.put(DNA.charAt(i), minho.get(DNA.charAt(i)) - 1);
                minho.put(DNA.charAt(i + P), minho.get(DNA.charAt(i + P)) + 1);
            }
        }

    }
}
