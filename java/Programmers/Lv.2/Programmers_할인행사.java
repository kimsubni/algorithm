
import java.util.*;

class Programmers_할인행사 {
    Map<String, Integer> map = new HashMap<>();
    int answer = 0;

    public int solution(String[] want, int[] number, String[] discount) {
        for (int i = 0; i < 10; ++i) {
            String fruit = discount[i];
            if (map.containsKey(fruit)) {
                map.put(fruit, map.get(fruit) + 1);
            } else {
                map.put(fruit, 1);
            }
        }
        check(want, number);
        int idx = 0;
        while (idx + 10 < discount.length) {
            String left = discount[idx];
            String right = discount[idx + 10];
            map.put(left, map.get(left) - 1);
            if (map.containsKey(right)) {
                map.put(right, map.get(right) + 1);
            } else {
                map.put(right, 1);
            }
            check(want, number);
            idx++;
        }
        return answer;
    }

    public void check(String[] want, int[] number) {
        for (int i = 0; i < want.length; ++i) {
            if (!map.containsKey(want[i])) {
                return;
            }
            if (map.get(want[i]) != number[i]) {
                return;
            }
        }
        answer++;
    }
}