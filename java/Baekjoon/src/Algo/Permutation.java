package Algo;

import java.util.Arrays;

public class Permutation {
    static int arr[];
    static boolean[] isSelected;
    static int[] numbers;
    static int N = 5;
    static int R = 3;

    public static void main(String[] args) {
        arr = new int[] { 1, 2, 3, 4, 5 };
        isSelected = new boolean[N];
        numbers = new int[R];

        per(0);
    }

    public static void per(int cnt) {
        if (cnt == R) {
            System.out.println(Arrays.toString(numbers));
            return;
        }
        for (int i = 0; i < N; ++i) {
            if (isSelected[i])
                continue;
            numbers[cnt] = arr[i];
            isSelected[i] = true;
            per(cnt + 1);
            isSelected[i] = false;
        }
    }
}
