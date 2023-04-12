package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_9934_완전이진트리 {
    static int K;
    static int N;
    static List<Integer>[] tree;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        N = (int) Math.pow(2, K) - 1;
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        tree = new ArrayList[K];
        for (int i = 0; i < K; ++i) {
            tree[i] = new ArrayList<>();
        }
        StringBuffer sb = new StringBuffer();
        find(0, 0, N - 1);
        for (int i = 0; i < K; ++i) {
            for (int num : tree[i]) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void find(int dep, int left, int right) {
        if (left > right) {
            return;
        }
        int mid = (right + left) / 2;
        tree[dep].add(arr[mid]);
        find(dep + 1, left, mid - 1);
        find(dep + 1, mid + 1, right);

    }

}
