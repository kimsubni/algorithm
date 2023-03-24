package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1916_최소비용구하기 {
    static final int INF = Integer.MAX_VALUE;
    static int N, M;
    static int S, E;
    static List<Node>[] adjList;
    static int[] cost;

    static class Node implements Comparable<Node> {
        int num;
        int cost;

        Node(int num, int cost) {
            this.num = num;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        cost = new int[N + 1];
        adjList = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; ++i) {
            adjList[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adjList[s].add(new Node(e, c));
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        djikstra();
        System.out.println(cost[E]);
    }

    private static void djikstra() {
        boolean[] visited = new boolean[N + 1];
        Arrays.fill(cost, INF);
        cost[S] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(S, 0));

        while (!pq.isEmpty()) {
            int now = pq.poll().num;

            if (visited[now]) {
                continue;
            }
            visited[now] = true;

            for (Node next : adjList[now]) {
                if (cost[next.num] > cost[now] + next.cost) {
                    cost[next.num] = cost[now] + next.cost;

                    pq.offer(new Node(next.num, cost[next.num]));
                }
            }
        }

    }
}
