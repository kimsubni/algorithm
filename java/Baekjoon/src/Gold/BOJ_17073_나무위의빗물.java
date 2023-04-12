package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_17073_나무위의빗물 {
    static int N, W;
    static List<Integer>[] adjList;

    static class Node {
        int num;
        double water;

        Node(int num, double water) {
            this.num = num;
            this.water = water;
        }
    }

    static int cnt;
    static double sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        adjList = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; ++i) {
            adjList[i] = new ArrayList<>();
        }
        cnt = 0;
        sum = 0.0;
        for (int i = 0; i < N - 1; ++i) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            adjList[s].add(e);
            adjList[e].add(s);
        }
        dfs(1);
        double answer = sum / (double) cnt;
        System.out.println(String.format("%.10f", answer));
    }

    static void dfs(int start) {
        boolean[] visited = new boolean[N + 1];
        Stack<Node> stack = new Stack<>();
        stack.push(new Node(start, W));
        while (!stack.isEmpty()) {
            Node now = stack.pop();
            if (visited[now.num]) {
                continue;
            }
            visited[now.num] = true;
            List<Integer> list = adjList[now.num];
            int child = 0;
            for (int num : list) {
                if (!visited[num]) {
                    child++;
                }
            }
            if (child == 0) {
                // 리프노드다!
                cnt++;
                sum += now.water;
            } else {
                // 자식이 있다 = 리프노드가 아니다.
                double share = now.water / (double) child;
                for (int next : list) {
                    stack.push(new Node(next, share));
                }
            }
        }
    }
}
