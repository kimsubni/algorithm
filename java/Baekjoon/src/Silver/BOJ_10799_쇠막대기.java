package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_10799_쇠막대기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] == '(') {
                if (arr[i + 1] == ')') {
                    ans += stack.size();
                    i++;
                    continue;
                }
                stack.push(1);
            }
            if (arr[i] == ')') {
                stack.pop();
                ans++;
            }
        }

        System.out.println(ans);
    }
}
