package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BOJ_2800_괄호제거 {
    static String str;
    static boolean[] flag;
    static List<String> answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        flag = new boolean[str.length()];
        answer = new ArrayList<>();
        solution(str);
        Collections.sort(answer);
        for (String ans : answer) {
            System.out.println(ans);
        }
    }

    public static void solution(String str) {
        Queue<String> q = new LinkedList<>();
        q.offer(str);
        while (!q.isEmpty()) {
            String now = q.poll();
            Stack<Integer> stack = new Stack<>();
            nowFor: for (int i = 0; i < now.length(); ++i) {
                if (now.charAt(i) == '(') {
                    stack.push(i);
                } else if (now.charAt(i) == ')') {
                    String next = "";
                    next = now.substring(0, i) + now.substring(i + 1);
                    int start = stack.pop();
                    next = next.substring(0, start) + next.substring(start + 1);
                    for (String st : answer) {
                        if (next.equals(st)) {
                            continue nowFor;
                        }
                    }
                    q.offer(next);
                    answer.add(next);
                }
            }
        }
    }
}
