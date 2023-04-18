package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15685_드래곤커브 {
    static int N;
    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, -1, 0, 1 };

    static boolean[][] map;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new boolean[101][101];
        StringTokenizer st;
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            dragonCurve(x, y, d, g);
        }

        for (int i = 0; i < 100; ++i) {
            for (int j = 0; j < 100; ++j) {
                if (map[i][j] && map[i][j + 1] && map[i + 1][j] && map[i + 1][j + 1]) {
                    ans++;
                }
            }

        }
        System.out.println(ans);
    }

    private static void dragonCurve(int x, int y, int d, int g) {
        List<Integer> list = new ArrayList<>();
        list.add(d);

        for (int i = 1; i <= g; ++i) {
            for (int j = list.size() - 1; j >= 0; --j) {
                list.add((list.get(j) + 1) % 4);
            }
        }
        map[y][x] = true;
        for (int dir : list) {
            x += dx[dir];
            y += dy[dir];
            map[y][x] = true;
        }
    }
}
