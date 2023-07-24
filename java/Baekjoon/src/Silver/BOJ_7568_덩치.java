package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_7568_덩치 {
    static class Person {
        int w, h;
        int rank;

        Person(int w, int h, int rank) {
            this.w = w;
            this.h = h;
            this.rank = rank;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Person[] people = new Person[N];
        StringTokenizer st;
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            people[i] = new Person(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 1);
        }

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                if (i == j)
                    continue;
                if (people[i].w < people[j].w && people[i].h < people[j].h) {
                    people[i].rank++;
                }
            }
        }

        for (int i = 0; i < N; ++i) {
            System.out.println(people[i].rank);
        }

    }
}
