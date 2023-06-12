
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

// 비트마스킹
class Solution {

    int max, ans[], apeach[];

    void find(int n, int cur) {
        int score = 0, state[] = new int[11];
        for (int i = 1; i <= 10; i++) {
            if ((cur & 1 << i) > 0) {
                n -= state[10 - i] = apeach[10 - i] + 1;
                if (n < 0)
                    return;
                score += i;
            } else if (apeach[10 - i] > 0)
                score -= i;
        }
        if (score <= 0)
            return;
        state[10] = n;
        if (max < score) {
            max = score;
            ans = state;
        } else if (max == score) {
            for (int i = 10; i >= 0; i--) {
                if (ans[i] != state[i]) {
                    if (state[i] > ans[i])
                        ans = state;
                    return;
                }
            }
        }
    }

    int[] solution(int n, int[] info) {
        apeach = info;
        for (int i = 1; i < 1 << 11; i++)
            if (Integer.bitCount(i) <= n)
                find(n, i);

        return max == 0 ? new int[] { -1 } : ans;
    }
}

// 다른 방법~
class OtherSolution {
    static int[] res = { -1 };
    static int[] lion;
    static int max = -1000;

    public void dfs(int[] info, int cnt, int n) {
        if (cnt == n + 1) {
            int apeach_point = 0;
            int lion_point = 0;
            for (int i = 0; i <= 10; i++) {
                if (info[i] != 0 || lion[i] != 0) {
                    if (info[i] < lion[i])
                        lion_point += 10 - i;
                    else
                        apeach_point += 10 - i;
                }
            }
            if (lion_point > apeach_point) {
                if (lion_point - apeach_point >= max) {
                    res = lion.clone();
                    max = lion_point - apeach_point;
                }
            }
            return;
        }

        for (int j = 0; j <= 10 && lion[j] <= info[j]; j++) {
            lion[j]++;
            dfs(info, cnt + 1, n);
            lion[j]--;
        }
    }

    public int[] solution(int n, int[] info) {
        lion = new int[11];
        dfs(info, 1, n);
        return res;
    }
}
