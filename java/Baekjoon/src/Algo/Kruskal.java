package Algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Kruskal {

    static class Edge implements Comparable<Edge> {
        int s;
        int e;
        int weight;

        Edge(int s, int e, int weight) {
            this.s = s;
            this.e = e;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    static StringTokenizer st;
    static int v;
    static int e;
    static int[] parent;
    static PriorityQueue<Edge> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        pq = new PriorityQueue<>();
        parent = new int[v + 1];

        // 부모 세팅
        for (int i = 1; i < v + 1; ++i) {
            parent[i] = i;
        }

        for (int i = 0; i < e; ++i) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            pq.offer(new Edge(s, e, w));
        }

        // 사이클 확인
        int weight = 0;
        while (!pq.isEmpty()) {
            Edge now = pq.poll();

            // 부모노드가 다를때만 사이클x
            if (getParent(now.s) != getParent(now.e)) {
                union(now.s, now.e);
                weight += now.weight;
            }
        }

        System.out.println(weight);
    }

    static void union(int a, int b) {
        a = getParent(a);
        b = getParent(b);

        if (a < b) {
            parent[b] = a;
        } else
            parent[a] = b;
    }

    static int getParent(int x) {
        if (parent[x] == x)
            return x;
        return parent[x] = getParent(parent[x]);
    }
}
