package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1976_여행가자 {
    static int[] parent;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        parent = new int[N + 1];
        for (int i = 1; i < N + 1; ++i) {
            parent[i] = i;
        }
        StringTokenizer st;
        for (int i = 1; i < N + 1; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N + 1; ++j) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    // 연결돼있다면
                    unionParent(i, j);
                }
            }
        }
        st = new StringTokenizer(br.readLine());

        boolean flag = true;
        int a = Integer.parseInt(st.nextToken());
        for (int i = 1; i < M; ++i) {
            int b = Integer.parseInt(st.nextToken());
            if (findParent(a, b) == 0) {
                flag = false;
                break;
            }
            a = b;
        }
        if (flag) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    static void unionParent(int a, int b) {
        a = getParent(a);
        b = getParent(b);
        if (a == b) {
            return;
        }
        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    static int getParent(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = getParent(parent[x]);
    }

    static int findParent(int a, int b) {
        a = getParent(a);
        b = getParent(b);
        if (a == b) {
            return 1;
        } else
            return 0;
    }
}
