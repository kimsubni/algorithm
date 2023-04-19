package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16235_나무재태크 {
    static int N, M, K;
    static int[][] A;
    static int[][] map;

    static class Tree implements Comparable<Tree> {
        int r, c, age;

        Tree(int r, int c, int age) {
            this.r = r;
            this.c = c;
            this.age = age;
        }

        @Override
        public int compareTo(Tree o) {
            return this.age - o.age;
        }
    }

    static List<Tree> deadTree;
    static int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
    static int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };
    static Deque<Tree> trees;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        trees = new LinkedList<>();
        deadTree = new ArrayList<>();
        A = new int[N][N];
        map = new int[N][N];
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; ++j) {
                A[i][j] = Integer.parseInt(st.nextToken());
                map[i][j] = 5;
            }
        }

        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int age = Integer.parseInt(st.nextToken());
            trees.add(new Tree(r, c, age));
        }

        for (int i = 0; i < K; ++i) {
            spring();
            summer();
            autumn();
            winter();
        }

        // 정답을 출력하자.
        System.out.println(trees.size());
    }

    private static void spring() {
        // 봄
        for (int i = 0; i < trees.size();) {
            Tree cur = trees.poll();
            if (map[cur.r][cur.c] >= cur.age) {
                map[cur.r][cur.c] -= cur.age;
                cur.age++;
                i++;
                trees.add(cur);
            } else {
                deadTree.add(cur);
            }
        }
    }

    /*
     * 봄에 죽은 나무가 양분으로 변하게 된다.
     * 각각의 죽은 나무마다 나이를 2로 나눈 값이 나무가 있던 칸에 양분으로 추가
     */
    private static void summer() {
        for (Tree now : deadTree) {
            map[now.r][now.c] += now.age / 2;
        }
        deadTree.clear();

    }

    /*
     * 나무가 번식한다 나무는 나이가 5의 배수이어야 한다. 8칸에 나이가 1인 나무가 생긴다.
     * 범위에서 벗어나면 나무가 생기지 않는다.
     */
    private static void autumn() {
        // 가을
        Queue<Tree> tmp = new LinkedList<>();
        for (Tree t : trees) {
            if (t.age % 5 == 0) {
                tmp.add(t);
            }
        }
        while (!tmp.isEmpty()) {
            Tree t = tmp.poll();

            for (int i = 0; i < 8; i++) {
                int nr = t.r + dr[i];
                int nc = t.c + dc[i];
                if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                    trees.addFirst(new Tree(nr, nc, 1));
                }
            }
        }
    }

    private static void winter() {
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                map[i][j] += A[i][j];
            }
        }
    }

}
