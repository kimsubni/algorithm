package Gold;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Pos {
    int r;
    int c;
    int cnt;
    boolean[] alphabet;

    public Pos(int r, int c, int cnt, boolean[] alphabet) {
        this.r = r;
        this.c = c;
        this.cnt = cnt;
        this.alphabet = alphabet;
    }
}

public class BOJ_1987_알파벳 {
    static char[][] board;
    static boolean[][] visited;
    static int[] dr = { 0, 1, 0, -1 };
    static int[] dc = { 1, 0, -1, 0 };
    static int R, C;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];
        visited = new boolean[R][C];
        for (int i = 0; i < R; ++i) {
            String str = br.readLine();
            for (int j = 0; j < C; ++j) {
                board[i][j] = str.charAt(j);
            }
        }
        answer = 1;
        Pos start = new Pos(0, 0, 1, new boolean[26]);
        start.alphabet[board[0][0] - 'A'] = true;
        dfs(start);
        System.out.println(answer);
    }

    public static void dfs(Pos now) {
        answer = Math.max(answer, now.cnt);
        for (int i = 0; i < 4; ++i) {
            int nr = dr[i] + now.r;
            int nc = dc[i] + now.c;
            if (nr < 0 || nc < 0 || nr >= R || nc >= C) {
                continue;
            }
            int alpaIdx = board[nr][nc] - 'A';
            if (!visited[nr][nc] && !now.alphabet[alpaIdx]) {
                visited[nr][nc] = true;
                boolean[] tmp = now.alphabet.clone();
                tmp[alpaIdx] = true;
                dfs(new Pos(nr, nc, now.cnt + 1, tmp));
                visited[nr][nc] = false;
            }
        }
    }

}