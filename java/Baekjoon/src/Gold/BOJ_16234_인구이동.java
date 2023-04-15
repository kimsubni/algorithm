package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16234_인구이동 {
    static int N, L, R;
    static int[][] map;
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };
    static boolean[][] visited;
    static boolean[][] checked;
    static int cnt;
    static int sum;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int day = 0;
        while (true) {
            visited = new boolean[N][N];
            checked = new boolean[N][N];
            flag = false;
            for (int i = 0; i < N; ++i) {
                for (int j = 0; j < N; ++j) {
                    if (!visited[i][j]) {
                        // 이 새로운 체크를 어떻게 표현했을지? 다른사람들은?=
                        visited[i][j] = true;
                        cnt = 1;
                        sum = map[i][j];
                        findPossible(i, j);
                        // 여기서 인구수를 설정해주자.
                        if (cnt > 1)
                            setPopulation();
                        else if (cnt == 1) {
                            checked[i][j] = true;
                        }
                    }

                }
            }
            if (!flag) {
                break;
            }
            day++;
        }
        System.out.println(day);
    }

    private static void setPopulation() {
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                if (!checked[i][j] && visited[i][j]) {
                    map[i][j] = (sum / cnt);
                    checked[i][j] = true;
                }
            }
        }
    }

    static void findPossible(int r, int c) {
        for (int i = 0; i < 4; ++i) {
            int nr = dr[i] + r;
            int nc = dc[i] + c;
            if (nr < 0 || nc < 0 || nr >= N || nc >= N) {
                continue;
            }
            int val = Math.abs(map[r][c] - map[nr][nc]);
            if (!visited[nr][nc] && val >= L && val <= R) {
                flag = true;
                visited[nr][nc] = true;
                findPossible(nr, nc);
                cnt++;
                sum += map[nr][nc];
            }
        }
    }
}
