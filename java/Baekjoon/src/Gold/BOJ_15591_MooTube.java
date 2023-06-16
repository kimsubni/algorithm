package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.List;
import java.util.PriorityQueue;

public class BOJ_15591_MooTube {
    static int N;
    static long Q;
    static List<Node>[] adjList;
    static long[] dist;
    static boolean[] visited;
    static final long INF = Long.MAX_VALUE;

    static class Node implements Comparable<Node> {
        int num;
        long cost;

        Node(int num, long cost) {
            this.num = num;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.cost, o.cost);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();
        N = Integer.parseInt(st.nextToken());
        Q = Long.parseLong(st.nextToken());
        adjList = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        dist = new long[N + 1];
        for (int i = 1; i < N + 1; ++i) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; ++i) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adjList[s].add(new Node(e, c));
            adjList[e].add(new Node(s, c));
        }

        for (int i = 0; i < Q; ++i) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            sb.append(dijkstra(v, k)).append('\n');
        }
        System.out.println(sb);
    }

    static public int dijkstra(int start, long k) {
        Arrays.fill(dist, INF);
        visited = new boolean[N + 1];
        visited[start] = true;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            for (Node next : adjList[now.num]) {
                if (visited[next.num]) {
                    continue;
                }
                visited[next.num] = true;
                dist[next.num] = Math.min(dist[next.num], next.cost);
                dist[next.num] = Math.min(dist[now.num], dist[next.num]);
                pq.offer(new Node(next.num, dist[next.num]));
            }
        }
        int cnt = 0;
        for (int i = 1; i < N + 1; ++i) {
            if (dist[i] >= k && dist[i] != INF) {
                cnt++;
            }
        }
        return cnt;
    }
}
