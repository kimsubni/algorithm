package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1389_케빈베이컨의6단계법칙 {
    static int N, M;
    static int[][] friend;
    static final int INF = 101;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        friend = new int[N + 1][N + 1];
        for (int i = 1; i < N + 1; ++i) {
            for (int j = 1; j < N + 1; ++j) {
                if (i == j) {
                    friend[i][j] = 0;
                    continue;
                }
                friend[i][j] = INF;
            }
        }
        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            friend[A][B] = 1;
            friend[B][A] = 1;
        }

        for (int k = 1; k < N + 1; ++k) {
            for (int i = 1; i < N + 1; ++i) {
                for (int j = 1; j < N + 1; ++j) {
                    friend[i][j] = Math.min(friend[i][j], friend[i][k] + friend[k][j]);
                }
            }
        }
        int minIdx = 0;
        int min = INF;
        for (int i = 1; i < N + 1; ++i) {
            int sum = 0;
            for (int j = 1; j < N + 1; ++j) {
                sum += friend[i][j];
            }
            if (min > sum) {
                minIdx = i;
                min = sum;
            }
        }
        System.out.println(minIdx);
    }
}
// 케빈 베이컨의 6단계 법칙에 의하면 지구에 있는 모든 사람들은 최대 6단계 이내에서
// 서로 아는 사람으로 연결될 수 있다.
// 케빈 베이컨 게임은 임의의 두 사람이 최소 몇단계 만에 이어질 수 있는지 계산하는 게임이다.
