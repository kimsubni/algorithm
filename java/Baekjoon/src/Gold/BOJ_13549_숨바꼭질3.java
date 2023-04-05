package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13549_숨바꼭질3 {
    static Queue<Pos> q;
    static int N, K;

    static class Pos {
        int pos;
        int cnt;

        Pos(int pos, int cnt) {
            this.pos = pos;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        solution(N);
    }

    private static void solution(int start) {
        boolean[] visited = new boolean[100001];
        q = new LinkedList<Pos>();
        q.offer(new Pos(start, 0));
        while (!q.isEmpty()) {
            Pos now = q.poll();
            if (now.pos == K) {
                System.out.println(now.cnt);
                return;
            }
            if (visited[now.pos]) {
                continue;
            }
            visited[now.pos] = true;
            if (now.pos * 2 >= 0 && now.pos * 2 < 100001)
                q.add(new Pos(now.pos * 2, now.cnt));
            if (now.pos - 1 >= 0 && now.pos - 1 < 100001)
                q.add(new Pos(now.pos - 1, now.cnt + 1));

            if (now.pos + 1 >= 0 && now.pos + 1 < 100001)
                q.add(new Pos(now.pos + 1, now.cnt + 1));

        }
    }
}