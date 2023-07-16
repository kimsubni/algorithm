package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2644_촌수계산 {
    static int p1, p2;
    static int n, m;
    static List<Integer>[] adjList;
    static int answer;

    static class Node {
        int idx, cost;

        Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        p1 = Integer.parseInt(st.nextToken());
        p2 = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(br.readLine());
        adjList = new ArrayList[n + 1];
        for (int i = 1; i <= n; ++i) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; ++i) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            adjList[s].add(e);
            adjList[e].add(s);
        }
        bfs();
        System.out.println(answer);
    }

    static void bfs() {
        boolean[] visited = new boolean[n + 1];
        visited[p1] = true;
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(p1, 0));
        while (!q.isEmpty()) {
            Node now = q.poll();
            if (now.idx == p2) {
                answer = now.cost;
                return;
            }
            for (int next : adjList[now.idx]) {
                if (!visited[next]) {
                    q.offer(new Node(next, now.cost + 1));
                    visited[next] = true;
                }
            }

        }
        answer = -1;
    }
}
