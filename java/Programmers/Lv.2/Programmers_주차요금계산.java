import java.util.*;

public class Programmers_주차요금계산 {
    Map<String, Integer> inCar = new HashMap<>();
    Map<String, Integer> ans = new HashMap<>();

    public int[] solution(int[] fees, String[] records) {
        for (int i = 0; i < records.length; ++i) {
            String[] str = records[i].split(" ");
            int time = timeToInt(str[0]);
            if ("IN".equals(str[2])) {
                inCar.put(str[1], time);
            } else if ("OUT".equals(str[2])) {
                int sub = time - inCar.get(str[1]);
                ans.put(str[1], sub + ans.getOrDefault(str[1], 0));
                inCar.put(str[1], -1);
            }
        }
        int lastTime = 23 * 60 + 59;
        for (String key : inCar.keySet()) {
            if (inCar.get(key) != -1) {
                int sub = lastTime - inCar.get(key);
                ans.put(key, sub + ans.getOrDefault(key, 0));
                inCar.put(key, -1);
            }
        }
        List<String> keyList = new ArrayList<>(ans.keySet());
        keyList.sort((s1, s2) -> s1.compareTo(s2));
        int[] answer = new int[ans.size()];
        int idx = 0;
        for (String key : keyList) {
            answer[idx] = (calFee(fees, ans.get(key), key));
            idx++;
        }

        return answer;
    }

    public int timeToInt(String str) {
        String[] time = str.split(":");
        int hour = Integer.parseInt(time[0]);
        int minute = Integer.parseInt(time[1]);
        return hour * 60 + minute;
    }

    public int calFee(int[] fees, int time, String str) {
        if (fees[0] >= time) {
            return fees[1];
        } else {
            return fees[1] + (int) Math.ceil(((double) time - fees[0]) / fees[2]) * fees[3];
        }
    }
}