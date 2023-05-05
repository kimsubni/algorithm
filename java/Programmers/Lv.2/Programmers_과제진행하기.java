
import java.util.*;

public class Programmers_과제진행하기 {
    static class Assignment implements Comparable<Assignment> {
        String name;
        int[] startTime;
        int playtime;

        Assignment(String name, int[] startTime, int playtime) {
            this.name = name;
            this.startTime = startTime;
            this.playtime = playtime;
        }

        @Override
        public int compareTo(Assignment o) {
            if (this.startTime[0] == o.startTime[0]) {
                return Integer.compare(this.startTime[1], o.startTime[1]);
            }
            return Integer.compare(this.startTime[0], o.startTime[0]);
        }
    }

    static Assignment[] assigns;
    static int N;

    public String[] solution(String[][] plans) {
        List<String> answer = new ArrayList<>();
        N = plans.length;
        assigns = new Assignment[N];
        for (int i = 0; i < plans.length; ++i) {
            String[] tmp = plans[i][1].split(":");
            int[] time = { Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]) };

            assigns[i] = new Assignment(plans[i][0], time, Integer.parseInt(plans[i][2]));
        }
        Arrays.sort(assigns);
        Stack<Assignment> stack = new Stack<>();
        for (int i = 0; i < N - 1; ++i) {
            Assignment now = assigns[i];
            // 끝나는 시각 계산하기
            int[] lastTime = calLastTime(now.startTime, now.playtime);
            Assignment next = assigns[i + 1];
            if (lastTime[0] < next.startTime[0]
                    || (lastTime[0] == next.startTime[0] && lastTime[1] <= next.startTime[1])) {
                answer.add(now.name);
                while (!stack.isEmpty()) {
                    Assignment prev = stack.pop();
                    int[] end = calLastTime(lastTime, prev.playtime);
                    if (end[0] < next.startTime[0] || (end[0] == next.startTime[0] && end[1] <= next.startTime[1])) {
                        // 다음보다 시간이 남는다면
                        answer.add(prev.name);
                        lastTime = end;
                    } else {
                        prev.playtime -= substrackTime(lastTime, next.startTime);
                        // 다음시간 - 현재시간만큼 playtime을 빼줘야한다!
                        stack.push(prev);
                        break;
                    }
                }
            } else {
                now.playtime -= substrackTime(now.startTime, next.startTime);
                stack.push(now);
            }
        }
        answer.add(assigns[N - 1].name);
        while (!stack.isEmpty()) {
            answer.add(stack.pop().name);
        }

        int size = 0;

        for (String a : answer) {
            size++;
        }

        String[] ans = new String[size];
        for (int i = 0; i < size; ++i) {
            ans[i] = answer.get(i);
        }
        return ans;
    }

    static public int[] calLastTime(int[] startTime, int playtime) {
        int[] result;
        result = new int[2];
        if (startTime[1] + playtime < 60) {
            result[0] = startTime[0];
            result[1] = startTime[1] + playtime;
            return result;
        }
        // 그게 아니면
        int sum = startTime[1] + playtime;
        result[0] = startTime[0] + sum / 60;
        result[1] = sum % 60;
        return result;
    }

    static public int substrackTime(int[] prevEndTime, int[] nextStartTime) {
        if (prevEndTime[1] > nextStartTime[1]) {
            int[] tmp = nextStartTime.clone();
            tmp[0] -= 1;
            return (60 + tmp[1] - prevEndTime[1]) + 60 * (tmp[0] - prevEndTime[0]);
        }
        return (nextStartTime[1] - prevEndTime[1] + 60 * (nextStartTime[0] - prevEndTime[0]));
    }
}
