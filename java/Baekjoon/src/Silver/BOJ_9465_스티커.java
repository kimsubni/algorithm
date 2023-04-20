package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9465_스티커 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; ++t) {
            int N = Integer.parseInt(br.readLine());
            int[][] sticker = new int[2][N + 1];
            StringTokenizer st;
            for (int i = 0; i < 2; ++i) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= N; ++j) {
                    sticker[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            sticker[0][1] += sticker[1][0];
            sticker[1][1] += sticker[0][0];
            for (int i = 2; i <= N; ++i) {
                sticker[0][i] = Math.max(Math.max(sticker[0][i - 2], sticker[1][i - 1]), sticker[1][i - 2])
                        + sticker[0][i];
                sticker[1][i] = Math.max(Math.max(sticker[1][i - 2], sticker[0][i - 1]), sticker[0][i - 2])
                        + sticker[1][i];
            }
            System.out.println(Math.max(sticker[0][N], sticker[1][N]));
        }
    }
}
