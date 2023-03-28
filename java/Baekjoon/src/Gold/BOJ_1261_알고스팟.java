package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 알고스팟 운영진이 모두 미로에 갇혔어.
 * 
 * 
 */
public class BOJ_1261_알고스팟 {
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };
    static int N, M;
    static int[][] map;
    static int min;

    static class Pos implements Comparable<Pos> {
        int r;
        int c;
        int cnt;
        int isPossible;

        Pos(int r, int c, int cnt, int isPossible) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.isPossible = isPossible;
        }

        @Override
        public int compareTo(Pos o) {
            if (this.isPossible == o.isPossible) {
                return Integer.compare(this.cnt, o.cnt);
            }
            return this.isPossible - o.isPossible;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N + 1][M + 1];
        for (int i = 1; i < N + 1; ++i) {
            String now = br.readLine();
            for (int j = 1; j < M + 1; ++j) {
                map[i][j] = now.charAt(j - 1) - '0';
            }
        }

        min = Integer.MAX_VALUE;
        bfs();
        System.out.println(min);
    }

    private static void bfs() {
        boolean[][] visited = new boolean[N + 1][M + 1];
        PriorityQueue<Pos> q = new PriorityQueue<>();

        visited[1][1] = true;
        q.offer(new Pos(1, 1, 0, 0));
        while (!q.isEmpty()) {
            Pos now = q.poll();
            if (now.r == N && now.c == M) {
                // 도착했을 때
                min = Math.min(min, now.cnt);
            }
            for (int i = 0; i < 4; ++i) {
                int nr = dr[i] + now.r;
                int nc = dc[i] + now.c;
                if (nr < 1 || nc < 1 || nr > N || nc > M) {
                    continue;
                }
                if (!visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.offer(new Pos(nr, nc, map[nr][nc] == 0 ? now.cnt : now.cnt + 1, map[nr][nc] == 0 ? 0 : 1));
                }
            }
        }
    }

}
