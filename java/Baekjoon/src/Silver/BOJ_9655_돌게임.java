package Silver;

import java.util.Scanner;

public class BOJ_9655_돌게임 {
    static int N;
    static boolean flag = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());
        recur(1, true);
        recur(3, true);

    }

    private static void recur(int idx, boolean who) {
        if (idx > N || flag) {
            return;
        }
        if (idx == N) {
            if (who) {
                System.out.println("SK");
            } else {
                System.out.println("CY");
            }
            flag = true;
            return;
        }

        recur(idx + 1, !who);
        recur(idx + 3, !who);
    }
}
