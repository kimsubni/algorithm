package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1005_ACMCraft {

    static int N, K, W;
    static int[] time;
    static int[] deph;
    static List<Integer>[] adjList;
    static Queue<Integer> pq;

    static int sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; ++tc) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            sum = 0;
            deph = new int[N + 1];
            time = new int[N + 1];
            adjList = new ArrayList[N + 1];
            for (int i = 1; i < N + 1; ++i) {
                adjList[i] = new ArrayList<>();
            }
            pq = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < N + 1; ++i) {
                time[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < K; ++i) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                adjList[s].add(e);
                deph[e]++;
            }
            for (int i = 1; i < N + 1; ++i) {
                if (deph[i] == 0) {
                    pq.add(i);
                }
            }
            W = Integer.parseInt(br.readLine());
            TopologySort();
        }

    }

    private static void TopologySort() {
        int[] result = time.clone();
        while (!pq.isEmpty()) {
            int now = pq.poll();
            List<Integer> list = adjList[now];
            for (int next : list) {
                result[next] = Math.max(result[next], result[now] + time[next]);
                deph[next]--;
                if (deph[next] == 0) {
                    pq.add(next);
                }
            }
        }
        System.out.println(result[W]);
    }
}
