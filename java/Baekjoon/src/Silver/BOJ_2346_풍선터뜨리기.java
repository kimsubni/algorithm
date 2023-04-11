package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_2346_풍선터뜨리기 {
    static class Balloon {
        int num;
        int cnt;

        Balloon(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<Balloon> q = new ArrayDeque<>();
        for (int i = 1; i < N + 1; ++i) {
            q.add(new Balloon(i, Integer.parseInt(st.nextToken())));
        }

        Balloon now = q.removeFirst();
        System.out.print(now.num + " ");
        while (!q.isEmpty()) {
            if (now.cnt > 0) {
                for (int i = 0; i < now.cnt; ++i) {
                    if (i == now.cnt - 1) {
                        now = q.removeFirst();
                        System.out.print(now.num + " ");
                        break;
                    }
                    q.addLast(q.removeFirst());
                }

            } else {
                for (int i = 0; i < Math.abs(now.cnt); ++i) {
                    if (i == Math.abs(now.cnt) - 1) {
                        now = q.removeLast();
                        System.out.print(now.num + " ");
                        break;
                    }
                    q.addFirst(q.removeLast());
                }
            }
        }

    }
}
