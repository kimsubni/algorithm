package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14888_연산자끼워넣기 {
    static int[] operation;
    static int N;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        operation = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; ++i) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; ++i) {
            operation[i] = Integer.parseInt(st.nextToken());
        }
        recur(nums[0], 1);
        System.out.println(max);
        System.out.println(min);

    }

    static void recur(int value, int idx) {
        if (idx == N) {
            min = Math.min(min, value);
            max = Math.max(max, value);
            return;
        }
        for (int i = 0; i < 4; ++i) {
            if (operation[i] > 0) {
                int tmp;
                if (i == 0) {
                    tmp = value + nums[idx];
                } else if (i == 1) {
                    tmp = value - nums[idx];
                } else if (i == 2) {
                    tmp = value * nums[idx];
                } else {
                    tmp = value / nums[idx];
                }
                operation[i]--;
                recur(tmp, idx + 1);
                operation[i]++;
            }
        }
    }

}
