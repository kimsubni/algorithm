
import java.util.*;

public class Programmers_두큐합같게만들기 {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long q1sum = 0, q2sum = 0;
        for (int i = 0; i < queue1.length; ++i) {
            q1.offer(queue1[i]);
            q1sum += queue1[i];
            q2.offer(queue2[i]);
            q2sum += queue2[i];

        }
        long totalSum = q2sum + q1sum;
        if (q1sum == q2sum) {
            return 0;
        }
        if (totalSum % 2 == 1) {
            return -1;
        }
        long sum = totalSum / 2;
        int idx = 1;
        while (idx <= queue1.length * 4) {
            if (q1sum < q2sum) {
                int now = q2.peek();
                if (q1sum + now < sum) {
                    int add = q2.poll();
                    q1.offer(add);
                    q1sum += add;
                    q2sum -= add;
                } else if (q1sum + now == sum) {
                    return idx;
                } else {
                    if (!q1.isEmpty()) {
                        int add = q1.poll();
                        q2.offer(add);
                        q1sum -= add;
                        q2sum += add;
                    } else {
                        return -1;
                    }
                }
            } else if (q1sum > q2sum) {
                int now = q1.peek();
                if (q2sum + now < sum) {
                    int add = q1.poll();
                    q2.offer(add);
                    q2sum += add;
                    q1sum -= add;
                } else if (q2sum + now == sum) {
                    return idx;
                } else {
                    if (!q2.isEmpty()) {
                        int add = q2.poll();
                        q1.offer(add);
                        q2sum -= add;
                        q1sum += add;
                    } else {
                        return -1;
                    }
                }
            } else {
                return idx;
            }
            idx++;
        }
        return -1;
    }
}
