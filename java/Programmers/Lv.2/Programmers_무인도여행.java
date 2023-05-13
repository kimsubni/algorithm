
import java.util.*;

class Programmers_무인도여행 {
    static List<Integer> ansTmp;
    static boolean[][] visited;
    static int N, M;

    static class Pos {
        int r, c;

        Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };

    public int[] solution(String[] maps) {
        ansTmp = new ArrayList<>();
        N = maps.length;
        M = maps[0].length();
        visited = new boolean[N][M];

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                if (!visited[i][j] && maps[i].charAt(j) != 'X') {
                    bfs(maps, i, j);
                }
            }
        }
        int[] answer;
        if (ansTmp.size() > 0) {
            answer = new int[ansTmp.size()];
            for (int i = 0; i < answer.length; ++i) {
                answer[i] = ansTmp.get(i);
            }
            Arrays.sort(answer);
        } else {
            answer = new int[1];
            answer[0] = -1;
        }

        return answer;
    }

    static public void bfs(String[] maps, int r, int c) {
        Queue<Pos> q = new LinkedList<>();
        q.offer(new Pos(r, c));
        visited[r][c] = true;
        int sum = 0;
        while (!q.isEmpty()) {
            Pos now = q.poll();
            sum += maps[now.r].charAt(now.c) - '0';
            for (int i = 0; i < 4; ++i) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];
                if (nr >= N || nc >= M || nc < 0 || nr < 0) {
                    continue;
                }
                if (!visited[nr][nc] && maps[nr].charAt(nc) != 'X') {
                    visited[nr][nc] = true;
                    q.offer(new Pos(nr, nc));
                }
            }
        }
        ansTmp.add(sum);
    }
}