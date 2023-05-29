
class Programmers_마법의엘리베이터 {
    static int min = Integer.MAX_VALUE;

    public int solution(int storey) {
        recur(storey, 0);
        return min;
    }

    static void recur(int storey, int ans) {
        if (min < ans) {
            return;
        }
        if (storey == 0) {
            min = Math.min(min, ans);
            return;
        }
        int num = storey % 10;
        recur((storey - num) / 10, ans + num);
        recur((storey + (10 - num)) / 10, ans + (10 - num));
    }
}
