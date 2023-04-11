package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_1935_후위표기식2 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        char[] order = br.readLine().toCharArray();
        int[] num = new int[N];
        for (int i = 0; i < N; ++i) {
            num[i] = Integer.parseInt(br.readLine());
        }
        Stack<Double> stack = new Stack<>();

        for (int i = 0; i < order.length; ++i) {
            int n = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf(order[i]);
            if (n >= 0) {
                stack.push((double) num[n]);
            } else {
                double a = stack.pop();
                double b = stack.pop();
                switch (order[i]) {
                    case '*':
                        stack.push(a * b);
                        break;
                    case '+':
                        stack.push(a + b);
                        break;
                    case '-':
                        stack.push(b - a);
                        break;
                    case '/':
                        stack.push(b / a);
                        break;
                }
            }
        }

        System.out.printf("%.2f", stack.pop());
    }
}
