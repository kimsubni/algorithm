
public class Programmers_표현가능한이진트리 {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];

        // 2진트리로 변환하기
        for (int i = 0; i < numbers.length; ++i) {
            String cur = Long.toBinaryString(numbers[i]);
            int j = 0;
            while ((int) Math.pow(2, j) - 1 < cur.length()) {
                j++;
            }
            while ((int) Math.pow(2, j) - 1 != cur.length()) {
                cur = "0" + cur;
            }
            if (recur(cur)) {
                answer[i] = 1;
            } else {
                answer[i] = 0;
            }
        }
        return answer;
    }

    static public boolean recur(String number) {
        int mid = (number.length() - 1) / 2;
        char root = number.charAt(mid);
        String left = number.substring(0, mid);
        String right = number.substring(mid + 1, number.length());
        if (root == '0'
                && (left.charAt((left.length() - 1) / 2) == '1' || right.charAt((right.length() - 1) / 2) == '1')) {
            return false;
        }
        boolean valid = true;
        if (left.length() >= 3) {
            valid = recur(left);
            if (valid) {
                valid = recur(right);
            }
        }

        return valid;
    }
}
