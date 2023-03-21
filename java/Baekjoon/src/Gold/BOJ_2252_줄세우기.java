package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2252_줄세우기 {
    static int N, M;
    static ArrayList<ArrayList<Integer>> student;
    static int[] edges;
    static StringBuffer sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuffer();
        // N : 학생의 수, M : 키를 비교한 수
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        edges = new int[N + 1];
        student = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < N + 1; ++i) {
            student.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // 진입차수와 그래프별 노드 설정
            student.get(a).add(b);
            edges[b]++;
        }

        topologySort();
        System.out.println(sb);
    }

    static void topologySort() {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < N + 1; ++i) {
            if (edges[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int now = q.poll();
            sb.append(now + " ");
            ArrayList<Integer> list = student.get(now);
            for (int i = 0; i < list.size(); ++i) {
                edges[list.get(i)]--;
                if (edges[list.get(i)] == 0) {
                    q.add(list.get(i));
                }
            }

        }
    }
}
