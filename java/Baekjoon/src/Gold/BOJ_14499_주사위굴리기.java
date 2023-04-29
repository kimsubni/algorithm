package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14499_주사위굴리기 {
    static int N, M, x, y, K;
    static int[][] map;
    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { 1, -1, 0, 0 };
    static int[] order;

    static class Dice {
        int top, bottom, left, right, front, behind;

        Dice(int top, int bottom, int left, int right, int front, int behind) {
            this.top = top;
            this.bottom = bottom;
            this.left = left;
            this.right = right;
            this.front = front;
            this.behind = behind;
        }
    }

    static Dice dice;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        order = new int[K];
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; ++j) {
                map[i][j] = Integer.parseUnsignedInt(st.nextToken());
            }
        }
        dice = new Dice(0, 0, 0, 0, 0, 0);
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; ++i) {
            int move = Integer.parseInt(st.nextToken()) - 1;
            x += dx[move];
            y += dy[move];

            if (x < 0 || x >= N || y < 0 || y >= M) {
                x -= dx[move];
                y -= dy[move];
                continue;
            }

            switch (move) {
                case 0:
                    right();
                    break;
                case 1:
                    left();
                    break;
                case 2:
                    north();
                    break;
                case 3:
                    south();
                    break;
            }
            if (map[x][y] == 0) {
                map[x][y] = dice.bottom;
            } else {
                dice.bottom = map[x][y];
                map[x][y] = 0;
            }
            System.out.println(dice.top);
        }

    }

    static public void north() {
        int tmp = dice.behind;
        dice.behind = dice.top;
        dice.top = dice.front;
        dice.front = dice.bottom;
        dice.bottom = tmp;
    }

    static public void south() {
        int tmp = dice.front;
        dice.front = dice.top;
        dice.top = dice.behind;
        dice.behind = dice.bottom;
        dice.bottom = tmp;
    }

    static public void right() {
        int tmp = dice.right;
        dice.right = dice.top;
        dice.top = dice.left;
        dice.left = dice.bottom;
        dice.bottom = tmp;

    }

    static public void left() {
        int tmp = dice.left;
        dice.left = dice.top;
        dice.top = dice.right;
        dice.right = dice.bottom;
        dice.bottom = tmp;

    }

}
