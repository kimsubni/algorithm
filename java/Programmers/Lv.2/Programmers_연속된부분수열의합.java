import java.util.*;

public class Programmers_연속된부분수열의합 {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int N = sequence.length;
        int[] sum = new int[N + 1];
        for (int i = 1; i <= N; ++i) {
            sum[i] = sum[i - 1] + sequence[i - 1];
            if (sequence[i - 1] == k) {
                int[] tmp = { i - 1, i - 1 };
                return tmp;
            }
        }
        int left = N;
        int right = N;
        int min = Integer.MAX_VALUE;
        while (left > 0) {
            if (sum[right] - sum[left - 1] > k) {
                right--;
                left--;
            } else if (sum[right] - sum[left - 1] < k) {
                left--;
            } else {
                int tmp = right - 1 - (left - 1);
                if (min >= tmp) {
                    answer[0] = left - 1;
                    answer[1] = right - 1;
                    min = Math.min(min, tmp);
                }
                right--;
                left--;
            }

        }

        return answer;
    }
}