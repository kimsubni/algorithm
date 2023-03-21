package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1043_거짓말 {
    static int N, M;
    static int[] parent;
    static boolean[] knowPeople;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<int[]> party = new ArrayList<int[]>();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        knowPeople = new boolean[51];
        parent = new int[N + 1];
        for (int i = 0; i < N + 1; ++i) {
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        for (int i = 0; i < K; ++i) {
            int a = Integer.parseInt(st.nextToken());
            unionParent(0, a);
            // 그짓말을 아는 사람들을 0번(지민이라고 하자) 합쳐버리자.
        }

        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine());
            int max = Integer.parseInt(st.nextToken());
            int[] nowParty = new int[max];
            int a = Integer.parseInt(st.nextToken());
            nowParty[0] = a;
            for (int j = 1; j < max; ++j) {
                int b = Integer.parseInt(st.nextToken());
                unionParent(a, b);
                nowParty[j] = b;
            }
            party.add(nowParty);
        }
        int count = 0;
        for (int i = 0; i < M; ++i) {
            int[] nowParty = party.get(i);
            if (!findParent(0, nowParty[0])) {
                count++;
            }
        }
        System.out.println(count);
    }

    static int getParent(int x) {
        if (parent[x] == x)
            return x;
        return parent[x] = getParent(parent[x]);
    }

    static void unionParent(int a, int b) {
        a = getParent(a);
        b = getParent(b);
        if (a < b) {
            parent[b] = a;
        } else
            parent[a] = b;
    }

    static boolean findParent(int a, int b) {
        a = getParent(a);
        b = getParent(b);

        if (a == b) {
            return true;
        }
        return false;
    }
}
