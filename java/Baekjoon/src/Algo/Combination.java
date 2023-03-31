package Algo;

import java.util.Arrays;

public class Combination {
    static int[] arr;
    static int[] numbers;
    static int N = 5;
    static int R = 3;

    public static void main(String[] args) {
        arr = new int[] { 1, 2, 3, 4, 5 };
        numbers = new int[R];
        comb(0, 0);
    }

    public static void comb(int start, int cnt) {
        if (cnt == R) {
            System.out.println(Arrays.toString(numbers));
            return;
        }

        for (int i = start; i < N; ++i) {
            numbers[cnt] = arr[i];
            comb(i + 1, cnt + 1);
        }
    }

    public static void combRep(int cnt) {
        if (cnt == R) {
            System.out.println(Arrays.toString(numbers));
            return;
        }
        for (int i = 0; i < N; ++i) {
            numbers[cnt] = arr[i];
            combRep(cnt + 1);
        }
    }
}
