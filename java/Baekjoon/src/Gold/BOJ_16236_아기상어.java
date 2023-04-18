package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16236_아기상어 {
    static int N;
    static int[][] map;
    static int time;
    static int eat = 0;
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, -1, 0, 1 };
    static boolean[][] visited;

    static class Fish {
        int r, c, size, cnt;

        Fish(int r, int c, int size, int cnt) {
            this.r = r;
            this.c = c;
            this.size = size;
            this.cnt = cnt;
        }
    }

    static Fish baby;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        map = new int[N][N];
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    baby = new Fish(i, j, 2, 0);
                    map[i][j] = 0;
                }
            }
        }
        bfs();
        System.out.println(time);
    }

    private static void bfs() {
        PriorityQueue<Fish> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.cnt == o2.cnt) {
                if (o1.r == o2.r) {
                    return Integer.compare(o1.c, o2.c);
                }
                return Integer.compare(o1.r, o2.r);
            }
            return Integer.compare(o1.cnt, o2.cnt);
        });
        visited = new boolean[N][N];
        Queue<Fish> q = new LinkedList<>();
        q.add(baby);
        visited[baby.r][baby.c] = true;

        while (!q.isEmpty()) {
            Fish now = q.poll();
            if (map[now.r][now.c] >= 1 && map[now.r][now.c] <= 6 && baby.size > map[now.r][now.c]) {
                pq.add(now);
            }
            for (int i = 0; i < 4; ++i) {
                int nr = dr[i] + now.r;
                int nc = dc[i] + now.c;
                if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
                    continue;
                }
                if (!visited[nr][nc] && baby.size >= map[nr][nc]) {
                    visited[nr][nc] = true;
                    q.offer(new Fish(nr, nc, now.size, now.cnt + 1));
                }
            }
        }

        if (pq.isEmpty()) {
            return;
        }

        Fish now = pq.poll();
        time += now.cnt;
        eat++;
        int size = baby.size;
        if (eat == baby.size) {
            size += 1;
            eat = 0;
        }
        baby = new Fish(now.r, now.c, size, 0);
        map[now.r][now.c] = 0;
        bfs();
    }

}
