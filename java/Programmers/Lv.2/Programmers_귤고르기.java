
import java.util.*;

public class Programmers_귤고르기 {
    public int solution(int k, int[] tangerine) {
        int N = tangerine.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; ++i) {
            if (map.containsKey(tangerine[i])) {
                map.put(tangerine[i], map.get(tangerine[i]) + 1);
            } else {
                map.put(tangerine[i], 1);
            }
        }
        /*
         * 
         * List<Integer> list = new ArrayList<>(map.keySet());
         * list.sort((o1, o2) -> map.get(o2)-map.get(o1));
         * 이렇게 하면더 빨랐겄당
         */
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i : map.keySet()) {
            pq.offer(map.get(i));
        }
        int cnt = 0;
        int sum = 0;
        while (sum < k) {
            sum += pq.poll();
            cnt++;
        }
        return cnt;
    }

}
