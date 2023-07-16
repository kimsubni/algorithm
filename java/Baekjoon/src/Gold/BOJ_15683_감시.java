package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15683_감시 {
    static int N, M;
    static int[][] map;
    static int[][] dr = { { -1, 0, 1, 0 }, {0, } };
    static int[][] dc = { { 0, 1, 0, -1 }, {} };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                if (map[i][j] >= 1 && map[i][j] <= 5) {

                }
            }
        }
    }
}
