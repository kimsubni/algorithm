package Algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BellmanFord {
    static class Edge {
        int s, e, c;

        Edge(int s, int e, int c) {
            this.s = s;
            this.e = e;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.valueOf(st.nextToken());
        int M = Integer.valueOf(st.nextToken());
        List<Edge> list = new ArrayList<>();
        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.add(new Edge(s, e, c));
        }

        long[] dist = new long[N + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[1] = 0;

        // n-1번의 반복작업과 마지막 확인작업을 한번에 돌림
        for (int i = 1; i < N + 1; ++i) {
            for (Edge now : list) {
                if (dist[now.s] == Long.MAX_VALUE)
                    continue;
                if (dist[now.e] > dist[now.s] + now.e) {
                    dist[now.e] = dist[now.s] + now.c;
                }
                if (i == N) {
                    System.out.println(-1);
                    System.exit(0);
                }
            }

        }
        for (int i = 2; i <= N; i++) {
            if (dist[i] == Long.MAX_VALUE) {
                System.out.println(-1);
            } else {
                System.out.println(dist[i]);
            }
        }
    }
}