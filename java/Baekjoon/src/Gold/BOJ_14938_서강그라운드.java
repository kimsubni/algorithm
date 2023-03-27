package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_14938_서강그라운드 {
    static class Node implements Comparable<Node> {
        int num;
        int dist;

        Node(int num, int dist) {
            this.num = num;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.dist, o.dist);
        }
    }

    static int[] dist;
    static int N, M, R;

    static List<Node>[] adjList;
    static int[] item;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 지역의 개수
        N = Integer.parseInt(st.nextToken());
        // 수색범위
        M = Integer.parseInt(st.nextToken());
        // 길의 개수
        R = Integer.parseInt(st.nextToken());
        dist = new int[N + 1];
        item = new int[N + 1];
        adjList = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; ++i) {
            adjList[i] = new ArrayList<>();
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; ++i) {
            item[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < R; ++i) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            adjList[a].add(new Node(b, l));
            adjList[b].add(new Node(a, l));
        }
        int max = 0;
        for (int i = 1; i < N + 1; ++i) {
            djikstra(i);
            int tmp = 0;
            for (int j = 1; j < N + 1; ++j) {
                if (dist[j] <= M) {
                    tmp += item[j];
                }
            }
            max = Math.max(max, tmp);
        }
        System.out.println(max);
    }

    private static void djikstra(int start) {
        boolean[] visited = new boolean[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            int now = pq.poll().num;
            if (visited[now])
                continue;
            visited[now] = true;

            for (Node next : adjList[now]) {
                if (dist[next.num] > dist[now] + next.dist) {
                    dist[next.num] = dist[now] + next.dist;
                }
                pq.offer(new Node(next.num, dist[next.num]));
            }
        }
    }

}
