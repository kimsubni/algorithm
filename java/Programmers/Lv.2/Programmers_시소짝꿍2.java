public class Programmers_시소짝꿍2 {
    public long solution(int[] weights) {
        long result = 0;
        int[] arr = new int[4001];
        for (int i = 0; i < weights.length; ++i) {
            int w = weights[i];
            result += arr[w] + arr[w * 2];
            if (w % 2 == 0)
                result += arr[w / 2];
            if (w * 2 % 3 == 0)
                result += arr[w * 2 / 3];
            if (w * 3 % 2 == 0)
                result += arr[w * 3 / 2];
            if (w * 3 % 4 == 0)
                result += arr[w * 3 / 4];
            if (w * 4 % 3 == 0)
                result += arr[w * 4 / 3];
            arr[w] += 1;
        }
        return result;
    }
}
