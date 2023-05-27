
import java.util.*;

public class Porgrammers_이모티콘할인행사 {
    static int dis[] = { 10, 20, 30, 40 };
    static int n, m;
    static int[] answer;
    static int[] sel;

    public int[] solution(int[][] users, int[] emoticons) {
        answer = new int[2];
        n = users.length;
        m = emoticons.length;
        sel = new int[m];
        recur(0, emoticons, users);
        return answer;
    }

    public void recur(int cnt, int[] emoticons, int[][] users) {
        if (cnt == m) {
            // 다 선택됐다.
            int sales = 0;
            int subscriber = 0;
            for (int i = 0; i < n; ++i) {
                int sum = 0;
                int ratio = users[i][0];
                int money = users[i][1];
                for (int j = 0; j < m; ++j) {
                    if (sel[j] < ratio) {
                        continue;
                    }
                    sum += emoticons[j] / 100 * (100 - sel[j]);
                }
                if (money > sum) {
                    sales += sum;
                } else {
                    subscriber++;
                }
            }
            if (answer[0] < subscriber) {
                answer[0] = subscriber;
                answer[1] = sales;
            } else if (answer[0] == subscriber) {
                if (answer[1] < sales) {
                    answer[1] = sales;
                }
            }
            return;
        }
        for (int i = 0; i < 4; ++i) {
            sel[cnt] = dis[i];
            recur(cnt + 1, emoticons, users);
        }
    }
}