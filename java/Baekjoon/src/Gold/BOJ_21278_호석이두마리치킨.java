package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_21278_호석이두마리치킨 {
    static int N, M;
    static int[] sel;
    static int R = 2;
    static int[][] dist;
    static final int INF = 1000000;
    static int min = INF;
    static int smallBuilding = INF;
    static int bigBuilding = INF;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dist = new int[N + 1][N + 1];

        for (int i = 1; i < N + 1; ++i) {
            for (int j = 1; j < N + 1; ++j) {
                if (i == j) {
                    dist[i][j] = 0;
                    continue;
                }
                dist[i][j] = INF;
            }
        }
        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            dist[s][e] = 1;
            dist[e][s] = 1;
        }
        sel = new int[R];
        for (int k = 1; k < N + 1; ++k) {
            for (int i = 1; i < N + 1; ++i) {
                for (int j = 1; j < N + 1; ++j) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        comb(1, 0);
        System.out.println(smallBuilding + " " + bigBuilding + " " + min);
    }

    private static void comb(int start, int cnt) {
        if (cnt == R) {
            int[] distance = new int[N + 1];
            for (int i = 1; i < N + 1; ++i) {
                distance[i] = Math.min(dist[sel[0]][i], dist[sel[1]][i]);
            }
            int sum = 0;
            for (int i = 1; i < N + 1; ++i) {
                sum += distance[i] * 2;
            }
            if (min > sum) {
                min = sum;
                smallBuilding = sel[0];
                bigBuilding = sel[1];
            }
            return;
        }

        for (int i = start; i < N + 1; ++i) {
            sel[cnt] = i;
            comb(i + 1, cnt + 1);
        }
    }

}
