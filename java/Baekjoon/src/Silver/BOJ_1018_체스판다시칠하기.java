package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1018_체스판다시칠하기 {
    static int N, M;
    static char[][] map;
    static int answer = Integer.MAX_VALUE;
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        for (int i = 0; i < N; ++i) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N - 8 + 1; ++i) {
            for (int j = 0; j < M - 8 + 1; ++j) {
                paintColor(i, j);
            }
        }
        System.out.println(answer);
    }

    private static void paintColor(int sR, int sC) {
        char[][] tmp = new char[8][8];
        for (int i = sR; i < sR + 8; ++i) {
            for (int j = sC; j < sC + 8; ++j) {
                tmp[i - sR][j - sC] = map[i][j];
            }
        }
        int cnt = 0;
        doPaint(copyTmp(tmp), cnt);
        tmp[0][0] = tmp[0][0] == 'B' ? 'W' : 'B';
        cnt++;
        doPaint(copyTmp(tmp), cnt);

    }

    private static char[][] copyTmp(char[][] tmp) {
        char[][] newTmp = new char[8][8];
        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                newTmp[i][j] = tmp[i][j];
            }
        }
        return newTmp;
    }

    private static void doPaint(char[][] tmpMap, int cnt) {
        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                char now = tmpMap[i][j];
                for (int k = 0; k < 4; ++k) {
                    int nr = dr[k] + i;
                    int nc = dc[k] + j;
                    if (nr < 0 || nc < 0 || nr >= 8 || nc >= 8) {
                        continue;
                    }
                    if (tmpMap[nr][nc] == now) {
                        if (now == 'W') {
                            tmpMap[nr][nc] = 'B';
                        } else {
                            tmpMap[nr][nc] = 'W';
                        }
                        cnt++;
                    }
                }
            }
        }
        answer = Math.min(answer, cnt);

    }
}
