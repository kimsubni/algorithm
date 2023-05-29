
import java.util.*;

class Programmers_테이블해시함수 {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        Arrays.sort(data, (o1, o2) -> {
            if (o1[col - 1] == o2[col - 1]) {
                return o2[0] - o1[0];
            }
            return o1[col - 1] - o2[col - 1];
        });
        int[] sum = new int[row_end - row_begin + 1];
        int idx = 0;
        for (int i = row_begin - 1; i < row_end; ++i) {
            for (int j = 0; j < data[0].length; ++j) {
                sum[idx] += (data[i][j] % (i + 1));
            }
            idx++;
        }
        answer = sum[0];
        for (int i = 1; i < sum.length; ++i) {
            answer ^= sum[i];
        }
        return answer;
    }
}