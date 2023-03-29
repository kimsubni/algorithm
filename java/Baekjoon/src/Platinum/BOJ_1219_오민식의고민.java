package Platinum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1219_오민식의고민 {
    static class Node {
        int start;
        int end;
        int cost;

        Node(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }

    static class Edge {
        int num;
        int cost;

        Edge(int num, int cost) {
            this.num = num;
            this.cost = cost;
        }
    }

    static int N, start, end, M;
    static List<Node> list;
    static List<Edge>[] adjList;
    static int[] money;
    static long[] cost;
    static final long INF = -Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();

        adjList = new ArrayList[N];
        for (int i = 0; i < N; ++i) {
            adjList[i] = new ArrayList<>();
        }
        money = new int[N];
        cost = new long[N];
        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.add(new Node(s, e, c * -1));
            adjList[s].add(new Edge(e, c));
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; ++i) {
            money[i] = Integer.parseInt(st.nextToken());
        }

        boolean isCycle = bellmanford();

        if (cost[end] == INF)
            if (isCycle) {
                System.out.println("Gee");
            } else
                System.out.println("gg");
        else {
            if (isCycle) {
                System.out.println("Gee");
            } else
                System.out.println(cost[end]);
        }
    }

    private static boolean bellmanford() {
        Arrays.fill(cost, INF);
        cost[start] = money[start];
        boolean flag = false;
        for (int i = 1; i < N + 1; ++i) {
            for (Node node : list) {
                if (cost[node.start] == INF) {
                    continue;
                }
                if (cost[node.end] < cost[node.start] + node.cost + money[node.end]) {
                    if (i == N) {
                        flag = hasCycle(node.end);
                        // false 일때 : 사이클이 end로 도달하지 못한다.
                        // true 일때 : 사이클이 end로 도달한다.
                        if (flag) {
                            return true;
                        }
                    }
                    cost[node.end] = cost[node.start] + node.cost + money[node.end];
                }
            }
        }
        return false;
    }

    private static boolean hasCycle(int num) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(num);
        boolean[] visited = new boolean[N];
        visited[num] = true;
        while (!q.isEmpty()) {
            int now = q.poll();
            List<Edge> tmpList = adjList[now];
            for (Edge edge : tmpList) {
                if (!visited[edge.num]) {
                    visited[edge.num] = true;
                    q.add(edge.num);
                }
            }
        }
        // System.out.println(Arrays.toString(visited));
        return visited[end];
    }
}
