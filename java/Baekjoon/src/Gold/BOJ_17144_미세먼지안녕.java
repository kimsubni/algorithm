package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_17144_미세먼지안녕 {
    static int R, C, T;
    static int[][] map;
    static int[] dr = { 0, -1, 0, 1 };
    static int[] dc = { 1, 0, -1, 0 };
    static int[][] tmp;
    static List<Pos> mRC = new ArrayList<>();

    static int ans;

    static class Pos {
        int r;
        int c;

        Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[R + 1][C + 1];

        for (int i = 1; i < R + 1; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < C + 1; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == -1) {
                    mRC.add(new Pos(i, j));
                }
            }
        }
        for (int t = 1; t <= T; ++t) {
            tmp = new int[R + 1][C + 1];
            // 시간.
            for (int r = 1; r <= R; ++r) {
                for (int c = 1; c <= C; ++c) {
                    if (map[r][c] > 0) {
                        spread(r, c);
                    }
                }
            }
            for (int r = 1; r <= R; ++r) {
                for (int c = 1; c <= C; ++c) {
                    if (map[r][c] != -1) {
                        map[r][c] = tmp[r][c];
                    }
                }
            }
            // 공기청정기가 돌기 시작한다.
            for (int i = 0; i < mRC.size(); ++i) {
                workMachine(mRC.get(i).r, mRC.get(i).c + 1, i);
                tmp[mRC.get(i).r][mRC.get(i).c + 1] = 0;
            }
            for (int r = 1; r <= R; ++r) {
                for (int c = 1; c <= C; ++c) {
                    if (map[r][c] != -1) {
                        map[r][c] = tmp[r][c];
                    }
                }
            }
        }
        for (int r = 1; r <= R; ++r) {
            for (int c = 1; c <= C; ++c) {
                ans += tmp[r][c];
            }
        }
        System.out.println(ans);

    }
    // 문제는 동시에 일어나는데. 내 로직대로 수행하면 먼저 오는것들을 먼저 수행한다.

    private static void workMachine(int r, int c, int upordown) {
        // upordown이 1이면 오른쪽으로 가고 오른쪽으로 가다가 왼쪽으로 가고. swap swap 해댄다.
        for (int i = 0; i < 4; ++i) {
            int nr = r;
            int nc = c;
            while (true) {
                nr += upordown == 0 ? dr[i] : (dr[i] * -1);
                nc += dc[i];
                if (nc > C || nr > R || nr < 1 || nc < 1 || map[nr][nc] == -1) {
                    break;
                }
                tmp[nr][nc] = map[r][c];
                r = nr;
                c = nc;
            }
        }

    }

    private static void spread(int r, int c) {
        int cnt = 0;
        for (int i = 0; i < 4; ++i) {
            int nr = dr[i] + r;
            int nc = dc[i] + c;
            if (nr < 1 || nc < 1 || nr > R || nc > C || map[nr][nc] == -1) {
                continue;
            }
            cnt++;
            tmp[nr][nc] += map[r][c] / 5;
        }
        tmp[r][c] += map[r][c] - (map[r][c] / 5 * cnt);
    }
}
