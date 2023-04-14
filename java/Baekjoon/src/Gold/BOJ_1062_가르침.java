package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
        * 1. 김지민은 K개의 글자를 가르칠 시간밖에 없다.
        * 2. 학생들은 그 K개의 글자로만 이루어진 단어만을 읽을 수 있다.
        * 3. 남극의 모든 단어는 "anta"로 시작되고 "tica"로 끝난다. 남극의 언어에 단어는 N개밖에 없다. 
        * Q. 어떤 K개의 글자를 가르쳐야 학생들이 읽을 수 있는 단어의 개수가 최대가 되는지 고민에 빠졌다. 
        * 
        */
public class BOJ_1062_가르침 {
    static int N, K;
    static String[] word;
    static int max = Integer.MIN_VALUE;
    static boolean[] alphabet = new boolean[26];
    static char[] ch = { 'a', 'n', 't', 'i', 'c' };
    static int[] sel;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        word = new String[N];
        for (int i = 0; i < N; ++i) {
            word[i] = br.readLine();
        }
        for (int i = 0; i < 5; ++i) {
            alphabet[ch[i] - 'a'] = true;
            for (int j = 0; j < N; ++j)
                word[j] = word[j].replace(String.valueOf(ch[i]), "");
        }
        if (K < 5) {
            System.out.println(0);
        } else {
            sel = new int[K - 5];
            comb(0, 0);
            System.out.println(max);
        }
    }

    public static void comb(int start, int cnt) {
        if (cnt == K - 5) {
            int count = 0;
            for (int i = 0; i < N; i++) { // 뽑은 알파벳으로 몇개의 단어를 읽을 수 있는지 카운트.
                boolean read = true;
                for (int j = 0; j < word[i].length(); j++) {
                    if (!alphabet[word[i].charAt(j) - 'a']) {
                        read = false;
                        break;
                    }
                }
                if (read)
                    count++;
            }
            max = Math.max(max, count);
            return;
        }
        for (int i = start; i < 26; ++i) {
            if (alphabet[i] == false) {
                alphabet[i] = true;
                sel[cnt] = i;
                comb(i, cnt + 1);
                alphabet[i] = false;
            }
        }
    }

}
