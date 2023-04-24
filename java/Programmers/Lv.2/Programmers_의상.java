import java.util.*;

class Programmers_의상 {
    static int answer;

    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < clothes.length; ++i) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 1) + 1);
        }
        answer = 1;
        System.out.println(map.entrySet());
        for (String key : map.keySet()) {
            answer *= map.get(key);
        }

        return answer - 1;
    }

}
