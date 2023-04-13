package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_11000_강의실배정 {
    static int N;

    static class Class {
        int start;
        int end;
        int num;

        Class(int start, int end, int num) {
            this.start = start;
            this.end = end;
            this.num = num;
        }

    }

    static boolean[] visited;
    static Class[] classes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        classes = new Class[N];
        StringTokenizer st;

        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            classes[i] = new Class(start, end, i);
        }

        visited = new boolean[N];
        Arrays.sort(classes, (l1, l2) -> l1.start == l2.start ? l1.end - l2.end : l1.start - l2.start);
        int ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(classes[0].end);

        for (int i = 1; i < N; ++i) {
            // 우선순위큐에서 가장 작은 종료시간과
            // 현재 classes의 시작시간을 비교

            if (pq.peek() <= classes[i].start) {
                pq.poll();
            }
            pq.offer(classes[i].end);
        }

        System.out.println(pq.size());

    }

}
