package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_1967_트리의지름 {
    static int N;
    static List<Node>[] adjList;
    static List<Integer> leaf;
    static int[] dist;

    static class Node {
        int end;
        int weight;

        Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }

    static int max = Integer.MIN_VALUE;
    static int maxIdx = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        adjList = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; ++i) {
            adjList[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for (int i = 0; i < N - 1; ++i) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adjList[s].add(new Node(e, c));
            adjList[e].add(new Node(s, c));
        }

        dfs(1);
        dfs(maxIdx);

        System.out.println(max);
    }

    static void dfs(int start) {
        boolean[] visited = new boolean[N + 1];
        Stack<StackNode> stack = new Stack<>();
        stack.push(new StackNode(start, 0));
        while (!stack.isEmpty()) {
            StackNode now = stack.pop();
            if (visited[now.num])
                continue;
            visited[now.num] = true;
            if (max < now.dist) {
                max = now.dist;
                maxIdx = now.num;
            }
            List<Node> list = adjList[now.num];

            for (Node next : list) {
                stack.push(new StackNode(next.end, now.dist + next.weight));
            }
        }
    }

    static class StackNode {
        int num;
        int dist;

        StackNode(int num, int dist) {
            this.num = num;
            this.dist = dist;
        }
    }

}
