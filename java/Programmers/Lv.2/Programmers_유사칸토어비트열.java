
public class Programmers_유사칸토어비트열 {

    public int solution(int n, long l, long r) {
        int answer = 0;

        for (long val = l; val <= r; val++) {
            answer += query(n, val - 1);
        }

        return answer;
    }

    int query(int n, long l) {
        if (n == 0 || l == 0)
            return 1;
        if (l % 5 == 2)
            return 0;
        return query(n - 1, l / 5);
    }

    public int solution2(int n, long l, long r) {
        long answer = r - l + 1;
        for (long i = l - 1; i <= r - 1; i++) {
            for (int j = 0; j < n; j++) {
                if ((i / (int) Math.pow(5, j)) % 5 == 2) {
                    answer--;
                    break;
                }
            }
        }

        return (int) answer;
    }

}
