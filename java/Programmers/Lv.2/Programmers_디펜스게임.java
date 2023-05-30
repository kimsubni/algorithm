
import java.util.*;

public class Programmers_디펜스게임 {
    static int answer = 0;

    public int solution(int n, int k, int[] enemy) {
        if (k >= enemy.length) {
            return enemy.length;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k; ++i) {
            pq.offer(enemy[i]);
        }
        int cnt = k;
        for (int i = k; i < enemy.length; i++) {
            if (pq.peek() < enemy[i]) {
                n -= pq.poll();
                pq.offer(enemy[i]);
            } else {
                n -= enemy[i];
            }

            if (n < 0)
                return cnt;
            else if (n == 0)
                return cnt + 1;

            cnt++;
        }

        return enemy.length;
    }
}
