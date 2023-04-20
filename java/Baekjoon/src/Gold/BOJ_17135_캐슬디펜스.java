package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_17135_캐슬디펜스 {
    static int N, M, D;
    static int[][] map;
    static int[] sel;
    static int R = 3;

    static class Enemy {
        int r, c;

        Enemy(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int[][] tmp;
    static PriorityQueue<Enemy> q;
    static List<Enemy> enemy;
    static int max, attackCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        sel = new int[R];
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 궁수 위치 뽑기
        comb(0, 0);

        System.out.println(max);
    }

    private static void comb(int start, int cnt) {
        if (cnt == R) {
            // 선택된 것이 sel 임.
            // 여기서 궁수 공격 들어가야댐. 끝까지 쳐야댐.
            attackCnt = 0;
            attack();
            max = Math.max(max, attackCnt);
            return;
        }

        for (int i = start; i < M; ++i) {
            sel[cnt] = i;
            comb(i + 1, cnt + 1);
        }
    }

    static HashSet<Enemy> removeEnemy;

    private static void attack() {
        enemy = new ArrayList<>();
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                if (map[i][j] == 1) {
                    enemy.add(new Enemy(i, j));
                }
            }
        }
        while (enemy.size() > 0) {
            removeEnemy = new HashSet<>();

            for (int i = 0; i < R; ++i) {
                hunterAttack(sel[i]);
            }

            Enemy[] arr = removeEnemy.toArray(new Enemy[0]);
            for (int i = 0; i < arr.length; ++i) {
                enemy.remove(arr[i]);
                attackCnt++;
            }

            List<Enemy> remove = new ArrayList<>();
            for (Enemy e : enemy) {
                int nr = e.r + 1;
                if (nr >= N) {
                    remove.add(e);
                    continue;
                }
                e.r = nr;
            }

            for (Enemy e : remove) {
                enemy.remove(e);
            }
        }
    }

    private static void hunterAttack(int select) {
        q = new PriorityQueue<>((o1, o2) -> {
            int dist1 = N - o1.r + Math.abs(select - o1.c);
            int dist2 = N - o2.r + Math.abs(select - o2.c);
            if (dist1 == dist2) {
                return Integer.compare(o1.c, o2.c);
            }
            return Integer.compare(dist1, dist2);
        });
        // i번째 궁수가 공격을 한다. 근데, 얘를 기준으로 가장 가깝고 왼쪽에있는 적을 공격할거다.
        for (Enemy e : enemy) {
            if (N - e.r + Math.abs(select - e.c) <= D)
                q.add(e);
        }
        if (q.isEmpty()) {
            return;
        }
        // 공격해라!
        removeEnemy.add(q.poll());
    }
}
