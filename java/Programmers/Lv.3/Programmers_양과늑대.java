
import java.util.*;

public class Programmers_양과늑대 {
    static List<Integer>[] adjList;
    static int remainSheep;
    static int N, M, answer;

    public int solution(int[] info, int[][] edges) {
        N = info.length;
        M = edges.length;
        adjList = new ArrayList[N];
        for (int i = 0; i < N; ++i) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; ++i) {
            int s = edges[i][0];
            int e = edges[i][1];
            adjList[s].add(e);
        }
        for (int i = 0; i < N; ++i) {
            if (info[i] == 0) {
                remainSheep++;
            }
        }
        List<Integer> canVisit = new ArrayList<>();
        canVisit.add(0);
        recur(info, 0, 1, 0, canVisit);
        return answer;
    }

    static public void recur(int[] info, int node, int sheep, int wolf, List<Integer> canVisit) {
        // 늑대가 양과 같아질때는 더이상 탐색할 필요가 없다.
        if (wolf == sheep) {
            return;
        }
        answer = Math.max(answer, sheep);
        if (answer == remainSheep) {
            return;
        }
        canVisit.remove(Integer.valueOf(node));

        // 방문할수 있는 곳 추가해주기
        for (int next : adjList[node]) {
            canVisit.add(next);
        }
        for (int next : canVisit) {
            // 방문할수있는 곳을 방문하러 간다.
            List<Integer> newList = new ArrayList<>();
            newList.addAll(canVisit);
            if (info[next] == 0) {
                recur(info, next, sheep + 1, wolf, newList);
            } else {
                recur(info, next, sheep, wolf + 1, newList);
            }
        }
        if (canVisit.size() == 0) {
            return;
        }

    }
}