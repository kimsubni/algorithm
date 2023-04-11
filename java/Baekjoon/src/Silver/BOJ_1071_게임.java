package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1071_게임 {
    static long X, Y, Z, ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 10판 해서 8번 이겼는데 최소 몇번을 해야 승률이 변할지.??
        ans = -1;
        X = Long.parseLong(st.nextToken());
        Y = Long.parseLong(st.nextToken());
        Z = Y * 100 / X;
        binarySearch();
        System.out.println(ans);
    }

    private static void binarySearch() {
        long start = 1;
        long end = X;
        while (start <= end) {
            long mid = (start + end) / 2;
            long num = (Y + mid) * 100 / (X + mid);
            if (num > Z) {
                // 달라졌다.
                ans = mid;
                end = mid - 1;
            } else {
                // 달라지지 않는다. = 게임을 더 해야한다.
                start = mid + 1;
            }
        }
    }
}
