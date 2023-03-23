package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1754_최단경로 {
    static class Node implements Comparable<Node> {
        int idx;
        int cost;

        // 정점번호, 가중치 저장
        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }

        // cost(=가중치) 중심으로 우선순위가 정해지기 때문에 compareTo 오버라이딩
        // 다른 방법으로 이를 생략하고 우선순위 큐 아래처럼 선언
        /**
         * PriorityQueue<Node> pq = new PriorityQueue<Node>
         * ((o1, o2) -> Integer.compare(o1.cost, o2.cost));
         **/
        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    static List<Node>[] adjList;
    static int V, E, K;
    static int[] dist;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        adjList = new ArrayList[V + 1];
        dist = new int[V + 1];
        Arrays.fill(dist, INF);
        for (int i = 0; i < V + 1; ++i) {
            adjList[i] = new ArrayList<Node>();
        }
        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < E; ++i) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adjList[u].add(new Node(v, w));
        }
        djikstra();

        for (int i = 1; i < V + 1; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }
    }

    static void djikstra() {
        boolean[] visited = new boolean[V + 1];
        // 최소거리 정보를 담을 배열을 초기화.
        // 출발지점의 비용은 0으로 시작
        dist[K] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(K, 0));
        // 다익스트라 알고리즘
        // 모든 노드를 방문하면 종료하기 때문에 노드 갯수만큼 반복
        while (!pq.isEmpty()) {
            int nowVertex = pq.poll().idx;

            if (visited[nowVertex])
                continue;
            visited[nowVertex] = true;

            // index의 연결된 정점 비교
            for (Node next : adjList[nowVertex]) {
                if (dist[next.idx] > dist[nowVertex] + next.cost) {
                    dist[next.idx] = dist[nowVertex] + next.cost;

                    pq.offer(new Node(next.idx, dist[next.idx]));
                }
            }
        }

    }
}
