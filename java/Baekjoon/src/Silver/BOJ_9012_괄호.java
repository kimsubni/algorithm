package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_9012_괄호 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; ++i) {
            if (solution(br.readLine())) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static boolean solution(String string) {
        char[] arr = string.toCharArray();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] == '(') {
                stack.push(1);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else
            return false;
    }

}
