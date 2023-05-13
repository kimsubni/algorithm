
// import java.util.*;

// public class Programmers_미로탈출명령어 {
//     static class Pos {
//         int r, c, cnt;
//         String str;

//         Pos(int r, int c, int cnt, String str) {
//             this.r = r;
//             this.c = c;
//             this.cnt = cnt;
//             this.str = str;
//         }
//     }

//     static int[] dr = { 1, 0, 0, -1 };
//     static int[] dc = { 0, -1, 1, 0 };
//     static String[] dir = { "d", "l", "r", "u" };

//     public String solution(int n, int m, int x, int y, int r, int c, int k) {
//         String answer = "impossible";
//         x -= 1;
//         r -= 1;
//         y -= 1;
//         c -= 1;
//         int se = getD(x, y, r, c);
//         if (x == r && c == y)
//             return "";
//         if (se > k || (k - se) % 2 == 1)
//             return answer;
//         Queue<Pos> q = new LinkedList<>();
//         q.offer(new Pos(x, y, 0, ""));
//         while (!q.isEmpty()) {
//             Pos now = q.poll();
//             if (now.cnt == k && now.r == r && now.c == c) {
//                 answer = now.str;
//                 break;
//             }
//             if (now.cnt > k) {
//                 continue;
//             }
//             if (now.cnt == k && (now.r != r || now.c != c)) {
//                 continue;
//             }
//             for (int i = 0; i < 4; ++i) {
//                 int nr = now.r + dr[i];
//                 int nc = now.c + dc[i];
//                 int d = getD(nr, nc, r, c);
//                 int nk = k - (now.cnt + 1);
//                 if (nr >= n || nc >= m || nr < 0 || nc < 0 || d > nk || (nk - d) % 2 == 1) {
//                     continue;
//                 }
//                 if (now.cnt + 1 <= k) {
//                     q.offer(new Pos(nr, nc, now.cnt + 1, now.str + dir[i]));
//                 }
//             }
//         }
//         return answer;
//     }

//     public int getD(int ax, int ay, int bx, int by) {
//         return Math.abs(ax - bx) + Math.abs(ay - by);
//     }
// }

import java.util.*;

public class Programmers_미로탈출명령어 {
    static class Pos {
        int r, c;
        StringBuilder sb;

        Pos(int r, int c, StringBuilder sb) {
            this.r = r;
            this.c = c;
            this.sb = sb;
        }
    }

    static int[] dr = { 1, 0, 0, -1 };
    static int[] dc = { 0, -1, 1, 0 };
    static String[] dir = { "d", "l", "r", "u" };

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        String answer = "impossible";
        x -= 1;
        r -= 1;
        y -= 1;
        c -= 1;
        int se = getD(x, y, r, c);

        if (x == r && c == y)
            return "";
        if (se > k || (k - se) % 2 == 1)
            return answer;
        Queue<Pos> q = new ArrayDeque<>();
        boolean[][][] chk = new boolean[n][m][k + 1];
        q.offer(new Pos(x, y, new StringBuilder("")));
        chk[x][y][0] = true;
        while (!q.isEmpty()) {
            Pos now = q.poll();
            int cnt = now.sb.toString().length();
            if (cnt == k && now.r == r && now.c == c) {
                answer = now.sb.toString();
                break;
            }
            if (cnt == k) {
                continue;
            }
            for (int i = 0; i < 4; ++i) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];
                int d = getD(nr, nc, r, c);
                int nk = k - (cnt + 1);
                if (nr >= n || nc >= m || nr < 0 || nc < 0 || chk[nr][nc][cnt + 1]) {
                    continue;
                }
                chk[nr][nc][now.sb.toString().length() + 1] = true;
                q.add(new Pos(nr, nc, new StringBuilder(now.sb).append(dir[i])));
            }
        }
        return answer;
    }

    public int getD(int ax, int ay, int bx, int by) {
        return Math.abs(ax - bx) + Math.abs(ay - by);
    }
}