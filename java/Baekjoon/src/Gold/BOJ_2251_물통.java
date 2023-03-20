package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Bucket {
    int A;
    int B;

    public Bucket(int A, int B) {
        this.A = A;
        this.B = B;
    }
}

public class BOJ_2251_물통 {
    static int[] now = new int[3];
    static boolean[] answer;
    static boolean[][] visited;
    static int[] sender = { 0, 0, 1, 1, 2, 2 };
    static int[] receiver = { 1, 2, 0, 2, 0, 1 };

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 3; ++i)
            now[i] = Integer.parseInt(st.nextToken());
        visited = new boolean[201][201];
        answer = new boolean[201];

        visited[0][0] = true;
        answer[now[2]] = true;
        dfs(new Bucket(0, 0));
        for (int i = 0; i < answer.length; ++i) {
            if (answer[i])
                System.out.print(i + " ");
        }
    }

    public static void dfs(Bucket nowBucket) {
        int A = nowBucket.A;
        int B = nowBucket.B;
        int C = now[2] - A - B;
        for (int i = 0; i < 6; ++i) {
            int[] next = { A, B, C };
            next[receiver[i]] += next[sender[i]];
            next[sender[i]] = 0;
            if (next[receiver[i]] > now[receiver[i]]) {
                // 물이 넘쳤을 경우, 초과하는 만큼 물을 넣어준다.
                next[sender[i]] = next[receiver[i]] - now[receiver[i]];
                next[receiver[i]] = now[receiver[i]];
            }
            if (!visited[next[0]][next[1]]) {
                visited[next[0]][next[1]] = true;
                dfs(new Bucket(next[0], next[1]));
                if (next[0] == 0) {
                    answer[next[2]] = true;
                }
            }
        }
    }
}