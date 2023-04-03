package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11403_경로찾기 {
    static int N;
    static boolean[] visited;
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        graph = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; ++j) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; ++i) {
            visited = new boolean[N];
            dfs(i, i);
        }
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }

    static public void dfs(int start, int now) {
        for (int i = 0; i < N; ++i) {
            if (graph[now][i] == 0)
                continue;
            if (!visited[i]) {
                visited[i] = true;
                graph[start][i] = 1;
                dfs(start, i);
            }
        }
    }
}
