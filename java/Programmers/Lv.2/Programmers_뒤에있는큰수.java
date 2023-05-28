
import java.util.*;

public class Programmers_뒤에있는큰수 {
    static class Node implements Comparable<Node> {
        int id, num;

        Node(int id, int num) {
            this.id = id;
            this.num = num;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.num, o.num);
        }
    }

    public int[] solution(int[] numbers) {
        int N = numbers.length;
        int[] answer = new int[N];
        Arrays.fill(answer, -1);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, numbers[0]));
        for (int i = 1; i < N; ++i) {
            while (!pq.isEmpty()) {
                Node prev = pq.peek();
                if (prev.num < numbers[i]) {
                    answer[prev.id] = numbers[i];
                    pq.poll();
                } else {
                    break;
                }
            }
            pq.offer(new Node(i, numbers[i]));
        }
        return answer;
    }
}
