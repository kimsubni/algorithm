
import java.util.*;

public class Porgrammers_파괴되지않은건물 {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int N = board.length;
        int M = board[0].length;
        int[][] preSum = new int[N + 1][M + 1];
        for (int i = 0; i < skill.length; ++i) {
            int type = skill[i][0];
            int r1 = skill[i][1], c1 = skill[i][2];
            int r2 = skill[i][3], c2 = skill[i][4];
            int degree = skill[i][5];

            if (type == 1)
                degree *= -1;
            preSum[r1][c1] += degree;
            preSum[r1][c2 + 1] += degree * (-1);
            preSum[r2 + 1][c1] += degree * (-1);
            preSum[r2 + 1][c2 + 1] += degree;
        }
        // 가로 누적합 계산
        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < M + 1; j++) {
                int p = j - 1 >= 0 ? preSum[i][j - 1] : 0;
                preSum[i][j] += p;
            }
        }

        // 세로 누적합 계산
        for (int i = 0; i < M + 1; i++) {
            for (int j = 0; j < N + 1; j++) {
                int p = j - 1 >= 0 ? preSum[j - 1][i] : 0;
                preSum[j][i] += p;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (preSum[i][j] + board[i][j] > 0)
                    answer++;
            }
        }

        return answer;
    }
}