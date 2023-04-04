package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 크루스칼 알고리즘 사용 목적
 * 가장 적은 비용으로 모든 노드를 연결하기 위해 
 */
public class BOJ_1922_네트워크연결 {
    static int N, M;
    static PriorityQueue<Edge> pq;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        pq = new PriorityQueue<>();
        parent = new int[N + 1];
        for (int i = 1; i < N + 1; ++i) {
            parent[i] = i;
        }

        StringTokenizer st;
        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            pq.add(new Edge(s, e, c));
        }

        kruskal();

    }

    private static void kruskal() {
        int cost = 0;
        while (!pq.isEmpty()) {
            Edge now = pq.poll();

            // 부모노드가 다를 때에만 사이클이 없다.
            if (getParent(now.s) != getParent(now.e)) {
                union(now.s, now.e);
                cost += now.cost;
            }
        }
        System.out.println(cost);
    }

    static int getParent(int x) {
        if (parent[x] == x)
            return x;
        return parent[x] = getParent(parent[x]);
    }

    static void union(int a, int b) {
        a = getParent(a);
        b = getParent(b);
        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    static class Edge implements Comparable<Edge> {
        int s;
        int e;
        int cost;

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
}
