package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1647_도시분할계획 {
    static int N, M;

    static class Edge implements Comparable<Edge> {
        int s, e, cost;

        Edge(int s, int e, int cost) {
            this.s = s;
            this.e = e;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    static List<Edge> adjList;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adjList = new ArrayList<>();
        parent = new int[N + 1];
        for (int i = 1; i < N + 1; ++i) {
            parent[i] = i;
        }
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            pq.offer(new Edge(s, e, c));
        }

        int weight = 0;
        // 사이클 확인할거야.
        int count = 0;

        while (count < N - 2) {
            Edge now = pq.poll();

            // 부모노드가 다를 떄만 사이클x
            if (getParent(now.s) != getParent(now.e)) {
                union(now.s, now.e);
                weight += now.cost;
                count++;
            }
        }

        System.out.println(weight);

    }

    static private void union(int a, int b) {
        a = getParent(a);
        b = getParent(b);

        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }

    }

    static private int getParent(int x) {
        if (x == parent[x])
            return x;
        return parent[x] = getParent(parent[x]);
    }
}
