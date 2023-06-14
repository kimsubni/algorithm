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

class Solution2 {

    public int timeToInt(String time) {
        String temp[] = time.split(":");
        return Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]);
    }

    public int[] solution(int[] fees, String[] records) {

        TreeMap<String, Integer> map = new TreeMap<>();

        for (String record : records) {
            String temp[] = record.split(" ");
            int time = temp[2].equals("IN") ? -1 : 1;
            time *= timeToInt(temp[0]);
            map.put(temp[1], map.getOrDefault(temp[1], 0) + time);
        }
        int idx = 0, ans[] = new int[map.size()];
        for (int time : map.values()) {
            if (time < 1)
                time += 1439;
            time -= fees[0];
            int cost = fees[1];
            if (time > 0)
                cost += (time % fees[2] == 0 ? time / fees[2] : time / fees[2] + 1) * fees[3];

            ans[idx++] = cost;
        }
        return ans;
    }
}
