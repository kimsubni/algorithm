
public class Programmers_유사비트열 {
    int start, end;
    int[] arr = { 0, 1, 2, 2, 3, 4 };

    public int solution(int n, long l, long r) {
        start = (int) Math.pow(5, n - 1) * 2 + 1;
        if (n > 1) {
            end = start + (int) Math.pow(5, n - 1);
            System.out.println(end);
        } else {
            end = start;
        }
        // 근데
        int left = count(l - 1);
        int right = count(r);

        return right - left;
    }

    public int count(long num) {
        long quo = num / 5;
        int rem = (int) (num % 5);
        int cnt = 0;
        if (num == 5) {
            cnt = 4;
        } else if (num >= end) {
            if (quo == 0) {
                cnt += arr[rem];
            } else {
                cnt += (4 * (quo - 1)) + arr[rem];
            }
        } else {
            cnt += (4 * quo) + arr[rem];
        }
        return cnt;
    }
}