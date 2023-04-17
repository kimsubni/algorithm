package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_20056_마법사상어와파이어볼 {
    static int N, M, K;
    static Stack<Fireball>[][] map;
    static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
    static int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };

    static class Fireball {
        int r, c, m, s, d;

        Fireball(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }

    static List<Fireball> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new Stack[N][N];
        list = new ArrayList<>();
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                map[i][j] = new Stack<>();
            }
        }
        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            list.add(new Fireball(r, c, m, s, d));
        }
        for (int i = 0; i < K; ++i) {
            goMove();
        }
        int ans = 0;
        for (Fireball f : list) {
            ans += f.m;
        }
        System.out.print(ans);
    }

    private static void goMove() {
        for (Fireball f : list) {
            f.r = (N + f.r + dr[f.d] * (f.s % N)) % N;
            f.c = (N + f.c + dc[f.d] * (f.s % N)) % N;
            // 이동하는 중에는 같은 칸에 여러 개의 파이어볼이 있을 수도 있다.
            map[f.r][f.c].push(f);
        }

        goMerge();
    }

    private static void goMerge() {
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                if (map[i][j].size() > 1) {
                    // 크기가 1보다 클때만.
                    int mSum = 0;
                    int sSum = 0;
                    int cnt = map[i][j].size();
                    boolean isOdd = true, isEven = true;
                    while (!map[i][j].isEmpty()) {
                        Fireball now = map[i][j].pop();
                        mSum += now.m;
                        sSum += now.s;
                        if (now.d % 2 == 1) {
                            isEven = false;
                        } else {
                            isOdd = false;
                        }
                        list.remove(now);
                    }
                    if (mSum / 5 > 0)
                        for (int k = 0; k < 4; ++k) {
                            if (isOdd || isEven) {
                                list.add(new Fireball(i, j, mSum / 5, sSum / cnt, k * 2));
                            } else {
                                list.add(new Fireball(i, j, mSum / 5, sSum / cnt, 1 + k * 2));
                            }
                        }
                } else {
                    map[i][j].clear();
                }
            }
        }
    }
}
