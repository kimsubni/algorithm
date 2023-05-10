
import java.util.*;
public class Programmers_리코쳇로봇 {
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int N,M;
    static int ans = -1;
    static boolean[][] visited;
    static class Pos{
        int r, c, cnt;
        Pos(int r, int c, int cnt){
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
    
    
    public int solution(String[] board) {
        N = board.length;
        M = board[0].length();
        visited = new boolean[N][M];
        for(int i = 0; i < N; ++i){
            for(int j = 0; j < M; ++j){
                if(board[i].charAt(j)=='R'){
                    bfs(i, j, board);
                }
            }
        }
        return ans;
    }
    static public void bfs(int r, int c, String[] board){
        Queue<Pos> q = new LinkedList<>();
        q.offer(new Pos(r,c,0));
        while(!q.isEmpty()){
            Pos now = q.poll();
            if(board[now.r].charAt(now.c) == 'G'){
                ans = now.cnt;
                return;
            }
            for(int i = 0; i < 4; ++i){
                int nr = now.r;
                int nc = now.c;
                while (nr < N && nc < M && nc >= 0 && nr >= 0 && board[nr].charAt(nc) != 'D') {
                    nr += dr[i];
                    nc += dc[i];
                }

                // 범위를 벗어나거나 장애물 만나기 '직전'의 상태
                nr -= dr[i];
                nc -= dc[i];

                // 방문을 하거나 같은 위치일 경우 스킵
                if (visited[nr][nc] || (now.r == nr && now.c == nc)) continue;

                visited[nr][nc] = true;
                q.offer(new Pos(nr, nc, now.cnt + 1));
            }
        }
    
    }
}