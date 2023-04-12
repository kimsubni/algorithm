package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_3584_가장가까운공통조상 {
    static int N;
    static List<Integer>[] adjList;
    static int A, B;
    static HashSet<Integer> parent;
    static StringBuffer sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        sb = new StringBuffer();
        for (int tc = 1; tc < T + 1; ++tc) {
            N = Integer.parseInt(br.readLine());
            adjList = new ArrayList[N + 1];
            for (int i = 1; i < N + 1; ++i) {
                adjList[i] = new ArrayList<>();
            }
            for (int i = 0; i < N - 1; ++i) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                adjList[e].add(s);
            }

            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            parent = new HashSet<>();
            dfs(A);
            dfs(B);
        }
        System.out.println(sb);
    }

    static void dfs(int start) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[N + 1];
        stack.push(start);
        while (!stack.isEmpty()) {
            int now = stack.pop();
            if (visited[now]) {
                continue;
            }
            visited[now] = true;
            if (!parent.contains(now)) {
                parent.add(now);
            } else {
                sb.append(now).append("\n");
                return;
            }

            List<Integer> list = adjList[now];
            for (int next : list) {
                stack.push(next);
            }
        }
    }
}
