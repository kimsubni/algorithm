package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_10021_WateringTheFields {
    static int N, C;
    static int[] parent;
    static boolean[][] visited;

    static class Node {
        private int x;
        private int y;
        private long value;

        Node(int x, int y, long value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }

    static class Field {
        private int x;
        private int y;

        Field(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static Field[] field;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];
        field = new Field[N];
        for (int i = 1; i <= N; ++i) {
            parent[i] = i;
        }
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            field[i] = new Field(x, y);
        }
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> (int) (o1.value - o2.value));
        for (int i = 0; i < N - 1; ++i) {
            for (int j = i + 1; j < N; ++j) {
                long dist = euclid(field[i], field[j]);
                pq.offer(new Node(i, j, dist));
            }
        }

        int sum = 0;
        int count = 0;
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if (node.value < C) {
                continue;
            }
            int x = node.x;
            int y = node.y;
            if (!isSameParent(x, y)) {
                sum += node.value;
                union(x, y);
                count++;
            }
            if (count == N - 1) {
                break;
            }
        }
        if (count != N - 1) {
            System.out.println(-1);
            return;
        }
        System.out.println(sum);

    }

    static int getParent(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = getParent(parent[x]);
    }

    static void union(int a, int b) {
        a = getParent(a);
        b = getParent(b);
        if (a != b)
            parent[b] = a;
    }

    static boolean isSameParent(int a, int b) {
        a = getParent(a);
        b = getParent(b);
        if (a == b) {
            return true;
        }
        return false;
    }

    static int euclid(Field a, Field b) {
        return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
    }
}
