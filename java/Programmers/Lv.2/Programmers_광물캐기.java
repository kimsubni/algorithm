
import java.util.*;

public class Programmers_광물캐기 {
    static int len, N;
    static int answer = Integer.MAX_VALUE;
    static int[][] graph = { { 1, 1, 1 }, { 5, 1, 1 }, { 25, 5, 1 } };
    static int[][] sum;

    public int solution(int[] picks, String[] minerals) {
        if (minerals.length % 5 == 0) {
            len = minerals.length / 5;
        } else {
            len = minerals.length / 5 + 1;
        }
        N = minerals.length;
        sum = new int[3][len];
        for (int i = 0; i < 3; ++i) {
            int idx = 0;
            for (int j = 0; j < N; ++j) {
                if (j % 5 == 0 && j != 0) {
                    idx++;
                }
                if (minerals[j].equals("diamond")) {
                    sum[i][idx] += graph[i][0];
                } else if (minerals[j].equals("iron")) {
                    sum[i][idx] += graph[i][1];
                } else {
                    sum[i][idx] += graph[i][2];
                }
            }
        }
        recur(0, 0, picks[0], picks[1], picks[2]);
        return answer;
    }

    static public void recur(int idx, int fatigue, int d, int i, int s) {
        if (idx == len || (d == 0 && i == 0 && s == 0)) {
            answer = Math.min(answer, fatigue);
            return;
        }
        if (d > 0) {
            recur(idx + 1, fatigue + sum[0][idx], d - 1, i, s);
        }
        if (i > 0) {
            recur(idx + 1, fatigue + sum[1][idx], d, i - 1, s);
        }
        if (s > 0) {
            recur(idx + 1, fatigue + sum[2][idx], d, i, s - 1);
        }
    }

}
