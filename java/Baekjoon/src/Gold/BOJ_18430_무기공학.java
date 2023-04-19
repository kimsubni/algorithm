import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] tree;
    static boolean[][] visited;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        tree = new int[N][M];

        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                tree[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.println(max);
    }

    private static void dfs(int cnt, int sum) {
        if (cnt == N * M) {
            // 다돌았다.
            max = Math.max(max, sum);
            return;
        }
        int r = cnt / M;
        int c = cnt % M;
        if (!visited[r][c]) {
            if (r + 1 < N && c - 1 >= 0 && !visited[r + 1][c] && !visited[r][c - 1]) {
                visited[r][c] = true;
                visited[r + 1][c] = true;
                visited[r][c - 1] = true;
                dfs(cnt + 1, sum + tree[r + 1][c] + tree[r][c - 1] + tree[r][c] * 2);
                visited[r][c] = false;
                visited[r + 1][c] = false;
                visited[r][c - 1] = false;
            }
            if (r + 1 < N && c + 1 < M && !visited[r + 1][c] && !visited[r][c + 1]) {
                visited[r][c] = true;
                visited[r + 1][c] = true;
                visited[r][c + 1] = true;
                dfs(cnt + 1, sum + tree[r + 1][c] + tree[r][c + 1] + tree[r][c] * 2);
                visited[r][c] = false;
                visited[r + 1][c] = false;
                visited[r][c + 1] = false;
            }

            if (r - 1 >= 0 && c - 1 >= 0 && !visited[r - 1][c] && !visited[r][c - 1]) {
                visited[r][c] = true;
                visited[r - 1][c] = true;
                visited[r][c - 1] = true;
                dfs(cnt + 1, sum + tree[r][c - 1] + tree[r - 1][c] + tree[r][c] * 2);
                visited[r][c] = false;
                visited[r - 1][c] = false;
                visited[r][c - 1] = false;
            }
            if (r - 1 >= 0 && c + 1 < M && !visited[r - 1][c] && !visited[r][c + 1]) {
                visited[r][c] = true;
                visited[r - 1][c] = true;
                visited[r][c + 1] = true;
                dfs(cnt + 1, sum + tree[r][c + 1] + tree[r - 1][c] + tree[r][c] * 2);
                visited[r][c] = false;
                visited[r - 1][c] = false;
                visited[r][c + 1] = false;
            }
        }

        dfs(cnt + 1, sum);

    }

}
