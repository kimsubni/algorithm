package Platinum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 위상정렬 사용 조건 
 * 1. DAG이다. (Directed acyclic graph)
 * 2. 사이클이 존재하지 않는 방향그래프이다.
 */
public class BOJ_1948_임계경로 {
    static int N, M;
    static int start, end;
    static int[] indegree;
    static int max, edgeCount;
    static boolean[][] maxVisited;
    static List<Edge>[] adjList;
    static List<Edge>[] RadjList;
    static int[] result;
    static int resultCount;

    static class Edge {
        private int targetNode;
        private int value;

        public Edge(int targetNode, int value) {
            this.targetNode = targetNode;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        indegree = new int[N + 1];
        adjList = new ArrayList[N + 1];
        RadjList = new ArrayList[N + 1];
        result = new int[N + 1];
        for (int i = 1; i < N + 1; ++i) {
            adjList[i] = new ArrayList<Edge>();
            RadjList[i] = new ArrayList<Edge>();
        }

        StringTokenizer st;
        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            adjList[s].add(new Edge(e, t));
            RadjList[e].add(new Edge(s, t));
            indegree[e]++;
        }
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        topologySort();
        reverse_topologySort();
        System.out.println(result[end]);
        System.out.println(resultCount);
    }

    private static void reverse_topologySort() {
        resultCount = 0;
        boolean visited[] = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(end);
        visited[end] = true;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (Edge next : RadjList[now]) {
                // 1분도 쉬지 않는 도로 체크
                if (result[next.targetNode] + next.value == result[now]) {
                    resultCount++;
                    // 중복 카운트 방지를 위해 이미 방문한 적 있는 노드 제외
                    if (!visited[next.targetNode]) {
                        visited[next.targetNode] = true;
                        queue.offer(next.targetNode);
                    }
                }
            }

        }
    }

    private static void topologySort() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (Edge next : adjList[now]) {
                indegree[next.targetNode]--;
                result[next.targetNode] = Math.max(result[next.targetNode], result[now] + next.value);
                if (indegree[next.targetNode] == 0) {
                    queue.offer(next.targetNode);
                }
            }
        }
    }
}
