package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_14500_테트로미노 {
    static int N, M;
    static int[][] map;
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };
    static int[][] er = { { 0, 0, 0, 1 }, { 1, 1, 1, 0 }, { 0, 1, 2, 1 }, { 0, 1, 2, 1 } }; // 세로
    static int[][] ec = { { 0, 1, 2, 1 }, { 0, 1, 2, 1 }, { 1, 1, 1, 0 }, { 0, 0, 0, 1 } }; // 가로
    static boolean[][] visited;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ans = 0;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[N][M];
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                visited[i][j] = true;
                dfs(i, j, map[i][j], 1);
                visited[i][j] = false;
                exceptionCase(i, j);

            }
        }
        System.out.println(ans);

    }

    private static void exceptionCase(int r, int c) {
        for (int i = 0; i < 4; ++i) {
            int sum = 0;
            for (int j = 0; j < 4; ++j) {
                int nr = er[i][j] + r;
                int nc = ec[i][j] + c;
                if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
                    break;
                }
                sum += map[nr][nc];
            }
            ans = Math.max(sum, ans);
        }
    }

    private static void dfs(int r, int c, int sum, int depth) {
        if (depth >= 4) {
            ans = Math.max(ans, sum);
            return;
        } else {

            for (int i = 0; i < 4; ++i) {
                int nr = dr[i] + r;
                int nc = dc[i] + c;
                if (nr < 0 || nr >= N || nc < 0 || nc >= M)
                    continue;
                if (!visited[nr][nc]) {
                    visited[nr][nc] = true;
                    dfs(nr, nc, (sum + map[nr][nc]), (depth + 1));
                    visited[nr][nc] = false;
                }
            }
        }
    }

}
