import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BellmanFord {
    public static void main(String[] args) throws IOException {
        // 입력을 위한 초기 설정
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 노드 수
        int V = Integer.parseInt(st.nextToken());
        // 간선 수
        int E = Integer.parseInt(st.nextToken());
        // 시작 노드
        int start = Integer.parseInt(br.readLine());
        // 목표 노드
        int target = Integer.parseInt(br.readLine());

        // 각 노드 별 연결된 간선들을 담을 배열
        Edge[] adjLink = new Edge[V + 1];

        // 입력 받은 간선들을 배열에 저장
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            adjLink[from] = new Edge(to, weight, adjLink[from]);
        }

        // 각 노드 별 최단 거리를 저장하는 배열
        int[] dist = new int[V + 1];
        // 방문 확인
        boolean[] visited = new boolean[V + 1];
        // 각 노드 별 최단 거리 최대값으로 초기화
        Arrays.fill(dist, Integer.MAX_VALUE);

        // 최단 거리를 O(N)이 아닌, O(logN)으로 뽑기 위한 우선순위큐 선언
        PriorityQueue<Vertex> pq = new PriorityQueue<>();

        // 시작 노드에 대한 거리 초기화
        dist[start] = 0;
        // 시작 노드 pq에 삽입
        pq.offer(new Vertex(start, 0));
        // 방문한 노드 갯수
        int count = 0;

        while (!pq.isEmpty()) {
            // 최단 거리인 Vertex 객체 가져오기
            Vertex curr = pq.poll();
            // 방문했던 노드인 경우 스킵
            if (visited[curr.no])
                continue;

            // 노드 방문처리
            visited[curr.no] = true;
            if (++count == V)
                break;

            // 선택된 노드와 연결된 노드들 중, 선택되지 않고 최단거리를 갱신해주는 값으로 갱신
            for (Edge e = adjLink[curr.no]; e != null; e = e.next) {
                if (!visited[e.to] && dist[e.to] > dist[curr.no] + e.weight) {
                    dist[e.to] = dist[curr.no] + e.weight;
                    pq.offer(new Vertex(e.to, dist[e.to]));
                }
            }
        }

        // 최종 결과인 목표 노드로의 거리 출력
        System.out.println((dist[target] == Integer.MAX_VALUE) ? "INF" : dist[target]);
    }

    static class Edge {
        int to;
        int weight;
        Edge next;

        public Edge(int to, int weight, Edge next) {
            this.to = to;
            this.weight = weight;
            this.next = next;
        }
    }

    static class Vertex implements Comparable<Vertex> {
        int no;
        int minDist;

        Vertex(int no, int minDist) {
            this.no = no;
            this.minDist = minDist;
        }

        // 최단 거리 순으로 정렬하기 위한 Comparable 인터페이스의 메소드 재정의
        @Override
        public int compareTo(Vertex v) {
            return this.minDist - v.minDist;
        }
    }

}
