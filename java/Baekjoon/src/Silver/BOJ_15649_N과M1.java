package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15649_N과M1 {
    static int N, M;
    static boolean[] isSelected;
    static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        isSelected = new boolean[N + 1];
        M = Integer.parseInt(st.nextToken());
        numbers = new int[M];

        per(0);

    }

    static void per(int cnt) {
        if (cnt == M) {
            for (int i = 0; i < M; ++i) {
                System.out.print(numbers[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= N; ++i) {
            if (isSelected[i])
                continue;
            numbers[cnt] = i;
            isSelected[i] = true;
            per(cnt + 1);
            isSelected[i] = false;
        }

    }
}
