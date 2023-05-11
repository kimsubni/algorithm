import java.util.*;

public class Programmers_부대복귀 {
    static List<Integer>[] list;
    static int[] dist;
    static final int INF = Integer.MAX_VALUE;
    static boolean[] checked;

    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        checked = new boolean[sources.length];
        list = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; ++i) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < roads.length; ++i) {
            int s = roads[i][0];
            int e = roads[i][1];
            list[s].add(e);
            list[e].add(s);
        }
        dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dijkstra(destination);
        for (int i = 0; i < sources.length; ++i) {
            if (dist[sources[i]] == INF) {
                dist[sources[i]] = -1;
            }
            answer[i] = dist[sources[i]];
        }
        return answer;
    }

    static public void dijkstra(int start) {
        Queue<Integer> q = new LinkedList<>();
        dist[start] = 0;
        q.offer(start);
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i = 0; i < list[now].size(); ++i) {
                if (dist[list[now].get(i)] > dist[now] + 1) {
                    dist[list[now].get(i)] = dist[now] + 1;
                    q.offer(list[now].get(i));
                }
            }
        }
    }
}
