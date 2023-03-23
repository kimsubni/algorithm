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
    static int[] edges;
    static int max, edgeCount;
    static boolean[][] maxVisited;
    static List<Edge>[] adjList;

    static class Edge {
        private int w;
        private int v;

        public void setEdge(int v, int w) {
            this.v = v;
            this.w = w;
        }

        public Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    static class Person {
        int city;
        int time;
        List<Integer> road;

        Person(int city, int time, List<Integer> road) {
            this.city = city;
            this.time = time;
            this.road = road;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        edges = new int[N + 1];
        adjList = new ArrayList[N + 1];
        maxVisited = new boolean[N + 1][N + 1];
        for (int i = 1; i < N + 1; ++i) {
            adjList[i] = new ArrayList<Edge>();
        }
        max = 0;

        StringTokenizer st;
        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            adjList[s].add(new Edge(e, t));
            edges[e]++;
        }
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        topologySort();

        System.out.println(max);
        System.out.println(edgeCount);
    }

    static void topologySort() {
        Queue<Person> q = new LinkedList<>();
        // 밟고있는 도시, 시간, 밟아온 길
        List<Integer> startRoad = new ArrayList<>();
        startRoad.add(start);
        q.add(new Person(start, 0, startRoad));
        while (!q.isEmpty()) {
            Person now = q.poll();
            List<Edge> list = adjList[now.city];
            if (now.city == end) {
                if (max < now.time) {
                    max = now.time;
                    // 만약 max 가 더 크면 다른작업을 해야겠지. max가 더 크면 visited를 갱신해준다. 자기가 걸은 길만.
                    // 얘가 걸어온 길만 비교해서 visited에 넣어주면? 어때? 걸어온길 ...
                    maxVisited = new boolean[N + 1][N + 1];
                    edgeCount = 0;
                    for (int i = 0; i < now.road.size() - 1; ++i) {
                        maxVisited[now.road.get(i)][now.road.get(i + 1)] = true;
                        edgeCount++;
                    }
                } else if (max == now.time) {
                    for (int i = 0; i < now.road.size() - 1; ++i) {
                        if (!maxVisited[now.road.get(i)][now.road.get(i + 1)]) {
                            maxVisited[now.road.get(i)][now.road.get(i + 1)] = true;
                            edgeCount++;
                        }
                    }
                }
            }
            for (int i = 0; i < list.size(); ++i) {
                int next = list.get(i).v;
                List<Integer> nextRoad = new ArrayList<>();
                nextRoad.addAll(now.road);
                nextRoad.add(next);
                q.add(new Person(next, now.time + list.get(i).w, nextRoad));
            }
        }
    }

}

// 로드를 걷고있는데 edges 가 처음과 비교했을 때 몇개가 줄었나를 통해 알아볼수있나?