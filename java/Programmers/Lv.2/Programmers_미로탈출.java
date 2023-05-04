import java.util.*;

public class Programmers_미로탈출 {
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };

    static class Pos {
        int r, c, cnt;

        Pos(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }

    static boolean find = false;
    static int answer;

    public int solution(String[] maps) {
        outer: for (int i = 0; i < maps.length; ++i) {
            for (int j = 0; j < maps[i].length(); ++j) {
                char now = maps[i].charAt(j);
                if (now == 'S') {
                    bfs(i, j, maps, 0, false);
                    break outer;
                }
            }
        }
        if (!find)
            answer = -1;
        return answer;
    }

    static public void bfs(int r, int c, String[] maps, int cnt, boolean flag) {
        Queue<Pos> q = new LinkedList<>();
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        q.offer(new Pos(r, c, cnt));
        visited[r][c] = true;
        while (!q.isEmpty()) {
            Pos now = q.poll();
            if (maps[now.r].charAt(now.c) == 'L' && !flag) {
                bfs(now.r, now.c, maps, now.cnt, true);
                return;
            }
            if (maps[now.r].charAt(now.c) == 'E' && flag) {
                answer = now.cnt;
                find = true;
                return;
            }
            for (int i = 0; i < 4; ++i) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];
                if (nr >= maps.length || nc >= maps[0].length() || nr < 0 || nc < 0) {
                    continue;
                }
                if (!visited[nr][nc] && maps[nr].charAt(nc) != 'X') {
                    visited[nr][nc] = true;
                    q.offer(new Pos(nr, nc, now.cnt + 1));
                }
            }
        }

    }
}