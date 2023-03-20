package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1717_집합의표현 {
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] parent = new int[N + 1];
        for (int i = 0; i < N + 1; ++i) {
            parent[i] = i;
        }
        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            int K = Integer.parseInt(st.nextToken());
            if (K == 0) {
                unionParent(parent, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            } else {
                if (findParent(parent, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())) == 1) {
                    System.out.println("YES");
                } else
                    System.out.println("NO");
            }

        }
    }

    static int getParent(int parent[], int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = getParent(parent, parent[x]);
    }

    static void unionParent(int parent[], int a, int b) {
        a = getParent(parent, a);
        b = getParent(parent, b);
        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    static int findParent(int parent[], int a, int b) {
        a = getParent(parent, a);
        b = getParent(parent, b);
        if (a == b)
            return 1;
        else
            return 0;
    }

}
