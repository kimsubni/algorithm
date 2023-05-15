
import java.util.*;

public class Programmers_등산코스정하기 {
    static class Node implements Comparable<Node> {
        int idx, cost;

        Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    static final int INF = Integer.MAX_VALUE;
    static int[] dist;
    static List<Node>[] adjList;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    static int summit = 0;

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        adjList = new List[n + 1];
        for (int i = 1; i < n + 1; ++i) {
            adjList[i] = new ArrayList<Node>();
        }
        for (int i = 0; i < paths.length; ++i) {
            int s = paths[i][0];
            int e = paths[i][1];
            int c = paths[i][2];
            adjList[s].add(new Node(e, c));
            adjList[e].add(new Node(s, c));
        }
        for (int i = 1; i < n + 1; ++i) {
            Collections.sort(adjList[i]);
        }
        dist = new int[n + 1];
        int[] answer = new int[2];
        for (int i = 0; i < gates.length; ++i) {
            visited = new boolean[n + 1];
            dijkstra(gates[i], summits);
        }
        answer[0] = summit;
        answer[1] = min;

        return answer;
    }

    static void dijkstra(int start, int[] summits) {
        Arrays.fill(dist, INF);
        dist[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        outer: while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (min < now.cost) {
                continue;
            }
            if (visited[now.idx]) {
                continue;
            }
            visited[now.idx] = true;
            for (int i = 0; i < summits.length; ++i) {
                if (now.idx == summits[i]) {
                    if (min > now.cost) {
                        min = now.cost;
                        summit = summits[i];
                    }
                    if (min == now.cost && summit > summits[i]) {
                        summit = summits[i];
                    }
                    continue outer;
                }

            }

            for (Node node : adjList[now.idx]) {
                int tmp = node.cost;
                if (now.idx != start) {
                    tmp = Math.max(node.cost, dist[now.idx]);
                }
                if (dist[node.idx] > tmp && !visited[node.idx]) {
                    dist[node.idx] = tmp;
                    pq.offer(new Node(node.idx, dist[node.idx]));
                }
            }
        }
    }

}
