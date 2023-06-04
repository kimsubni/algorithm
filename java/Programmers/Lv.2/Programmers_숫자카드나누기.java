import java.util.*;

public class Programmers_숫자카드나누기 {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        int maxA = find(arrayA);
        int maxB = find(arrayB);

        if (maxB != 0) {
            for (int i = 0; i < arrayA.length; ++i) {
                if (arrayA[i] % maxB == 0) {
                    break;
                }
                if (i == arrayA.length - 1) {
                    answer = maxB;
                }
            }
        }

        if (maxA != 0) {
            for (int i = 0; i < arrayB.length; ++i) {
                if (arrayB[i] % maxA == 0) {
                    break;
                }
                if (i == arrayB.length - 1) {
                    answer = Math.max(maxA, answer);
                }
            }
        }

        return answer;
    }

    public int find(int[] arr) {
        int max = 0;
        outer: for (int i = 2; i <= arr[0]; ++i) {
            for (int j = 0; j < arr.length; ++j) {
                if (arr[j] % i != 0) {
                    continue outer;
                }
            }
            max = Math.max(max, i);
        }
        return max;
    }
}
