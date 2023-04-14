package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ_1174_줄어드는수 {
    static int N;
    static int[] arr = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
    static List<Long> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        recur(0, 0);
        Collections.sort(list);

        if (list.size() > N - 1) {
            System.out.println(list.get(N - 1));
        } else {
            System.out.println(-1);
        }
    }

    static void recur(long num, int idx) {
        if (!list.contains(num)) {
            list.add(num);
        }

        if (idx >= 10) {
            return;
        }

        recur((num * 10) + arr[idx], idx + 1);
        recur(num, idx + 1);

    }
}
