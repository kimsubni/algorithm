package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1766_문제집 {
    static int N, M;
    static int[] edges;
    static List<Integer>[] adjList;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adjList = new ArrayList[N + 1];
        edges = new int[N + 1];
        for (int i = 1; i < N + 1; ++i) {
            adjList[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            adjList[s].add(e);
            edges[e]++;
        }
        topologySort();
        System.out.println(sb);
    }

    private static void topologySort() {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 1; i < N + 1; ++i) {
            if (edges[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int now = queue.poll();
            sb.append(now).append(" ");
            List<Integer> list = adjList[now];
            for (int next : list) {
                edges[next]--;
                if (edges[next] == 0) {
                    queue.add(next);
                }
            }
        }
    }
}
