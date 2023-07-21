package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10431_줄세우기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; ++t) {
            int answer = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            int[] student = new int[20];
            for (int i = 0; i < 20; ++i) {
                student[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i < 20; ++i) {
                for (int j = 0; j <= i; ++j) {
                    if (student[j] > student[i]) {
                        int tmp = student[j];
                        student[j] = student[i];
                        student[i] = tmp;
                        answer++;
                    }
                }
            }
            System.out.println(t + " " + answer);
        }
    }
}
