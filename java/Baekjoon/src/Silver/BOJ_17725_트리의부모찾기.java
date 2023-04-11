package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_17725_트리의부모찾기 {
    static List<Integer>[] adjlist;
    static int N;
    static int[] parent;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        parent = new int[N + 1];
        adjlist = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; ++i) {
            adjlist[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for (int i = 0; i < N - 1; ++i) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            adjlist[s].add(e);
            adjlist[e].add(s);
        }
        visited = new boolean[N + 1];

        dfs(1);
        visited[1] = true;

        for (int i = 2; i < N + 1; ++i) {
            System.out.println(parent[i]);
        }
    }

    private static void dfs(int now) {
        List<Integer> list = adjlist[now];
        for (int next : list) {
            if (!visited[next]) {
                visited[next] = true;
                parent[next] = now;
                dfs(next);
            }
        }
    }

}
