package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14466_소가길을건너간이유6 {
    static int N, K, R;
    static int[][] map;
    static boolean[][] checked;

    static class Pos {
        int r, c;

        Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static List<Pos>[][] path;
    static Pos[] cow;
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        path = new ArrayList[N + 1][N + 1];
        for (int i = 1; i < N + 1; ++i) {
            for (int j = 1; j < N + 1; ++j) {
                path[i][j] = new ArrayList<>();
            }
        }
        cow = new Pos[K + 1];
        map = new int[N + 1][N + 1];
        for (int i = 0; i < R; ++i) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());
            path[r1][c1].add(new Pos(r2, c2));
            path[r2][c2].add(new Pos(r1, c1));
        }
        for (int i = 1; i <= K; ++i) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            cow[i] = new Pos(r, c);
        }
        checked = new boolean[K + 1][K + 1];
        for (int i = 1; i <= K; ++i) {
            for (int j = 1; j <= K; ++j) {
                if (i == j)
                    continue;
                if (checked[i][j]) {
                    continue;
                }
                bfs(cow[i], cow[j], i, j);
            }
        }
        System.out.println(ans);
    }

    static public void bfs(Pos start, Pos end, int sid, int eid) {
        checked[sid][eid] = true;
        checked[eid][sid] = true;
        boolean[][] visited = new boolean[N + 1][N + 1];
        Queue<Pos> q = new LinkedList<>();
        visited[start.r][start.c] = true;
        q.offer(start);
        while (!q.isEmpty()) {
            Pos now = q.poll();
            if (now.r == end.r && end.c == now.c) { // 만날 수 있다.
                return;
            }
            outer: for (int i = 0; i < 4; ++i) {
                int nr = dr[i] + now.r;
                int nc = dc[i] + now.c;
                for (Pos pos : path[now.r][now.c]) {
                    if (pos.r == nr && pos.c == nc) {
                        continue outer;
                    }
                }

                if (nr < 1 || nc < 1 || nr > N || nc > N) {
                    continue;
                }
                if (!visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.offer(new Pos(nr, nc));
                }
            }
        }
        ans++;
    }
}
