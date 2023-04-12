package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_14675_단절점과단절선 {
    static int N, Q;
    static List<Integer>[] adjList;
    static int K; // 제거할 선 or 간선번호

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        adjList = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; ++i) {
            adjList[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for (int i = 0; i < N - 1; ++i) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            adjList[s].add(e);
            adjList[e].add(s);
        }
        Q = Integer.parseInt(br.readLine());
        System.out.println("질문개수 : " + Q);
        for (int i = 0; i < Q; ++i) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            if (type == 2)
                System.out.println("yes");
            else {
                int count = 0;
                for (int temp : adjList[K]) {
                    count++;
                }
                if (count >= 2)
                    System.out.println("yes");
                else
                    System.out.println("no");
            }
        }

    }

}
