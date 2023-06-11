
import java.util.*;

public class Programmers_양궁대회 {
    int max = 0;
    boolean flag = false;
    int[] result = new int[11];

    public int[] solution(int n, int[] info) {
        recur(n, new int[11], info, 0, 0);
        int[] not = { -1 };
        // System.out.println(Arrays.toString(result));
        return flag ? result : not;
    }

    public void recur(int n, int[] lion, int[] info, int cnt, int idx) {
        if (cnt > n || idx > 10) {
            return;
        }
        if (cnt == n) {
            whowin(info, lion);
            return;
        }

        if (info[idx] == 0) {
            lion[idx] = 1;
            recur(n, lion, info, cnt + 1, idx + 1);
            lion[idx] = 0;
        }
        if (info[idx] + 1 <= n - cnt) {
            lion[idx] = info[idx] + 1;
            recur(n, lion, info, cnt + (info[idx] + 1), idx + 1);
            lion[idx] = 0;
        } else {
            lion[idx] = n - cnt;
            if (idx + 1 > 10)
                recur(n, lion, info, n, idx);
            else
                recur(n, lion, info, n, idx + 1);
            lion[idx] = 0;
        }
        recur(n, lion, info, cnt, idx + 1);
    }

    public void whowin(int[] info, int[] lion) {
        int infoScore = 0;
        int lionScore = 0;
        for (int i = 0; i <= 10; ++i) {
            if (info[i] == 0 && lion[i] == 0)
                continue;
            if (info[i] < lion[i]) {
                lionScore += 10 - i;
            } else {
                infoScore += 10 - i;
            }
        }
        int sub = lionScore - infoScore;
        if (sub <= 0)
            return;
        if (max < sub) {
            max = sub;
            flag = true;
            result = lion.clone();
        } else if (max == sub) {
            int[] tmp = checkArr(lion, result);
            result = tmp.clone();
        }
    }

    private int[] checkArr(int[] a, int[] b) {
        for (int i = a.length - 1; i >= 0; i--) {
            if (a[i] == b[i])
                continue;
            if (a[i] < b[i])
                return b;
            break;
        }
        return a;
    }

}
