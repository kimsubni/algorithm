package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_25757_임스와함께하는미니게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        String game = st.nextToken();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; ++i) {
            set.add(br.readLine());
        }
        int answer = 0;
        switch (game) {
            case "Y":
                answer = set.size() / 1;
                break;
            case "F":
                answer = set.size() / 2;
                break;
            case "O":
                answer = set.size() / 3;
                break;
        }
        System.out.println(answer);
    }
}
