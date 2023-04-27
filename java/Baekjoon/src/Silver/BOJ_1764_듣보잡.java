package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1764_듣보잡 {
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        List<String> list = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < N; ++i) {
            String str = br.readLine();
            set.add(str);
        }
        for (int i = 0; i < M; ++i) {
            String str = br.readLine();
            if (!set.add(str)) {
                list.add(str);
            }
        }
        System.out.println(list.size());
        Collections.sort(list);
        for (String now : list) {
            System.out.println(now);
        }
    }
}
