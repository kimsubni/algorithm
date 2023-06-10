
import java.util.*;

public class Programmers_혼자놀기의달인 {
    PriorityQueue<List<Integer>> pq = new PriorityQueue<>((o1, o2) -> {
        return Integer.compare(o2.size(), o1.size());
    });
    boolean[] visited;

    public int solution(int[] cards) {
        int answer = 0;
        visited = new boolean[cards.length + 1];
        for (int i = 0; i < cards.length; ++i) {
            if (!visited[cards[i]]) {
                dfs(cards[i], cards, new ArrayList<>());
            }
        }
        if (pq.size() < 2) {
            return 0;
        }
        return pq.poll().size() * pq.poll().size();
    }

    public void dfs(int num, int[] cards, List<Integer> list) {
        if (visited[num]) {
            pq.add(list);
            return;
        }
        list.add(num);
        visited[num] = true;
        dfs(cards[num - 1], cards, list);

    }
}
