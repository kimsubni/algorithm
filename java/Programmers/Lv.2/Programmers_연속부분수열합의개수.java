
class Programmers_연속부분수열합의개수 {
    public int solution(int[] elements) {
        boolean[] visited = new boolean[1000001];
        int answer = 0;
        int len = elements.length * 2;
        int[] elements_two = new int[len];
        int[] sum = new int[len];
        for (int i = 0; i < len; ++i) {
            elements_two[i] = elements[i % (elements.length)];
        }
        sum[0] = elements_two[0];
        for (int i = 1; i < len; ++i) {
            sum[i] = sum[i - 1] + elements_two[i];
        }
        for (int i = 0; i < elements.length; ++i) {
            for (int j = 0; j < elements.length; ++j) {
                int now = 0;
                if (i == 0)
                    now = sum[j + i];
                else
                    now = sum[j + i] - sum[j];
                if (!visited[now]) {
                    visited[now] = true;
                    answer++;
                }
            }
        }
        return answer;
    }
}
