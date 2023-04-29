package Algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
sample input
5 6
1
5 1 1
1 2 2
1 3 3
2 3 4
2 4 5
3 4 6
 */

// 도착 지점과, 도착지점으로 가는 비용을 의미하는 클래스를 정의한다.
class Node implements Comparable<Node> {
    int idx;
    int cost;

    // 생성자
    Node(int idx, int cost) {
        this.idx = idx;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.cost, o.cost);
    }
}

public class Dijkstra {
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());

        ArrayList<Node>[] connections = new ArrayList[n + 1];
        for (int i = 1; i <= N; i++) {
            connections[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            connections[x].add(new Node(y, z));
        }

        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);

        dist[start] = 0;

        boolean[] visited = new boolean[N + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (visited[now.idx])
                continue;
            visited[now.idx] = true;
            for (Node node : connections[now.idx]) {
                if (dist[node.idx] > dist[now.idx] + node.cost) {
                    dist[node.idx] = dist[now.idx] + node.cost;
                    pq.add(new Node(node.idx, dist[node.idx]));
                }
            }
        }
    }
}