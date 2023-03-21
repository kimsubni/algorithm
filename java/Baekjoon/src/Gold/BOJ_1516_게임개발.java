package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1516_게임개발 {
    static int N;
    static int[] edges;
    static List<Integer>[] building;
    static int[] time;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        edges = new int[N + 1];
        time = new int[N + 1];
        building = new ArrayList[N + 1];
        answer = new int[N + 1];

        for (int i = 1; i < N + 1; ++i) {
            building[i] = new ArrayList<>();
        }

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int i = 1; i < N + 1; ++i) {
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());

            while (true) {
                int now = Integer.parseInt(st.nextToken());
                if (now == -1) {
                    break;
                }
                building[now].add(i);
                edges[i]++;
            }
        }
        topologySort();
        for (int i = 1; i < N + 1; ++i) {
            sb.append(answer[i]).append("\n");
        }
        System.out.println(sb);
    }

    static void topologySort() {
        Queue<Building> q = new LinkedList<>();
        // 진입차수가 0인것 queue 에 넣기.
        for (int i = 1; i < N + 1; ++i) {
            if (edges[i] == 0) {
                q.add(new Building(i, time[i]));
            }
        }
        int[] tmpTime = new int[N + 1];

        // queue에 담긴 노드가 0일때까지
        while (!q.isEmpty()) {
            Building now = q.poll();

            answer[now.num] = now.time;

            // 이런식으로하면 순서만 가능한거아녀?
            List<Integer> list = building[now.num];

            for (int i = 0; i < list.size(); ++i) {
                int next = list.get(i);
                edges[next]--;

                if (edges[next] == 0) {
                    if (tmpTime[next] < time[next] + now.time)
                        q.add(new Building(next, now.time + time[next]));
                    else {
                        q.add(new Building(next, tmpTime[next]));
                    }
                } else {
                    // 일단 지금 타임이랑 다음 타임 포함해서 비교해야겠따.
                    if (tmpTime[next] < now.time + time[next])
                        tmpTime[next] = now.time + time[next];
                }
            }
        }

    }

    static class Building {
        int time;
        int num;

        Building(int num, int time) {
            this.num = num;
            this.time = time;
        }
    }
}