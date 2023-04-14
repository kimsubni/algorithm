package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3980_선발명단 {
    static int[][] score;
    static boolean[] visited;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int tc = 1; tc <= T; ++tc) {
            max = Integer.MIN_VALUE;
            score = new int[11][11];
            visited = new boolean[11];
            for (int i = 0; i < 11; ++i) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 11; ++j) {
                    score[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            recur(0, 0);
            System.out.println(max);
        }
    }

    private static void recur(int idx, int sum) {
        if (idx == 11) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 11; ++i) {
            if (score[idx][i] > 0 && !visited[i]) {
                visited[i] = true;
                recur(idx + 1, sum + score[idx][i]);
                visited[i] = false;
            }
        }
    }
}
