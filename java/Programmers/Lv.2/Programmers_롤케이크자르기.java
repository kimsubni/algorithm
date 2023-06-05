
import java.util.*;

public class Programmers_롤케이크자르기 {
    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int t : topping) {
            if (map.containsKey(t)) {
                map.put(t, map.get(t) + 1);
            } else {
                map.put(t, 1);
            }
        }
        int cnt = 0;
        Set<Integer> set = new HashSet<>();
        for (int t : topping) {
            set.add(t);
            if (map.get(t) - 1 > 0) {
                map.put(t, map.get(t) - 1);
            } else {
                map.remove(t);
            }

            if (map.size() == set.size()) {
                answer++;
            } else if (map.size() < set.size()) {
                break;
            }
        }
        return answer;
    }
}