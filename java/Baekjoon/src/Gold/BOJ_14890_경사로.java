package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14890_경사로 {
    static int N, L;
    static int[][] map;
    static int ans = 0;

    static class Runway {
        int h, dir;

        Runway(int h, int dir) {
            this.h = h;
            this.dir = dir;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        checkMap(true);
        checkMap(false);

        System.out.println(ans);
    }

    static Runway[] checked;

    static private void checkMap(boolean isRow) {
        outer: for (int i = 0; i < N; ++i) {
            int len = 0;
            checked = new Runway[N];
            for (int k = 0; k < N; ++k) {
                checked[k] = new Runway(-1, 0);
            }
            for (int j = 1; j < N; ++j) {
                int sub = isRow ? map[i][j - 1] - map[i][j] : map[j - 1][i] - map[j][i];

                if (sub == 1)
                    len = 1;
                if (sub == 0 && len > 0)
                    len++;
                if (len == L) {
                    for (int k = 0; k < L; ++k) {
                        checked[j - k].h = k;
                        checked[j - k].dir = -1;
                    }
                    len = 0;
                }

            }
            len = 0;
            for (int j = N - 2; j >= 0; --j) {
                if (checked[j].h >= 0) {
                    len = 0;
                    continue;
                }
                int sub = isRow ? map[i][j + 1] - map[i][j] : map[j + 1][i] - map[j][i];
                if (sub == 1)
                    len = 1;
                if (sub == 0 && len > 0)
                    len++;
                if (len == L) {
                    for (int k = 0; k < L; ++k) {
                        checked[j + k].h = k;
                        checked[j + k].dir = 1;
                    }
                    len = 0;
                }
            }
            // check
            for (int j = 0; j < N - 1; ++j) {
                int sub = isRow ? map[i][j + 1] - map[i][j] : map[j + 1][i] - map[j][i];
                if ((sub == 1 && checked[j].h != L - 1) || Math.abs(sub) >= 2) {
                    continue outer;
                }
                if ((sub == 1 && checked[j].h == L - 1 && checked[j].dir != 1)) {
                    continue outer;
                }
            }
            for (int j = N - 1; j >= 1; --j) {
                int sub = isRow ? map[i][j - 1] - map[i][j] : map[j - 1][i] - map[j][i];
                if ((sub == 1 && checked[j].h != L - 1) || Math.abs(sub) >= 2) {
                    continue outer;
                }
                if ((sub == 1 && checked[j].h == L - 1 && checked[j].dir != -1)) {
                    continue outer;
                }
            }
            ans++;
            // System.out.println(i + "-------------------------");
            // for (int j = 0; j < N; ++j) {
            // System.out.print("h: " + checked[j].h + " , dir: " + checked[j].dir + " | ");
            // }
            // System.out.println();
        }
    }

}