package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_11657_타임머신 {
    static int N, M;
    static List<Node> adjList;
    static long[] dist;
    static final long INF = Long.MAX_VALUE;

    static class Node implements Comparable<Node> {
        int start;
        int time;
        int end;

        Node(int start, int end, int time) {
            this.start = start;
            this.end = end;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.time, o.time);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adjList = new ArrayList<>();
        dist = new long[N + 1];

        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adjList.add(new Node(s, e, c));
        }

        bellmanFord();

    }

    static void bellmanFord() {
        Arrays.fill(dist, INF);
        dist[1] = 0;
        // 정점의 수만큼 반복
        for (int i = 1; i < N + 1; ++i) {
            // 모든 간선을 돌면서
            for (Node node : adjList) {

                // from 까지 갈 수 없다면 갱신 x
                if (dist[node.start] == INF)
                    continue;
                if (dist[node.end] > dist[node.start] + node.time) {
                    if (i == N) {
                        // 음의 사이클이 존재한다!
                        System.out.println(-1);
                        return;
                    }
                    dist[node.end] = dist[node.start] + node.time;
                }
            }
        }
        for (int i = 2; i < N + 1; ++i) {
            if (dist[i] == INF) {
                System.out.println(-1);
                continue;
            }
            System.out.println(dist[i]);
        }

    }
}
