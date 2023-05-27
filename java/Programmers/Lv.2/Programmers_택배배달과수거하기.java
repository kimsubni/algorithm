
public class Programmers_택배배달과수거하기 {
    static int dels, pick;

    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        for (int i = 0; i < n; ++i) {
            if (deliveries[i] > 0) {
                dels++;
            }
            if (pickups[i] > 0) {
                pick++;
            }
        }
        while (true) {
            int dist = 0;
            if (dels > 0) {
                dist = doWork(deliveries, dist, true, cap, n);
            }
            if (pick > 0) {
                dist = doWork(pickups, dist, false, cap, n);
            }
            answer += dist * 2;
            if (pick == 0 && dels == 0)
                break;
        }
        return answer;
    }

    static int doWork(int[] arr, int dist, boolean isDels, int cap, int n) {
        int tmp = cap;
        for (int i = n - 1; i >= 0; --i) {
            if (arr[i] > 0) {
                dist = Math.max(dist, i + 1);
                if (arr[i] >= tmp) {
                    arr[i] -= tmp;
                    tmp = 0;
                    if (arr[i] == 0) {
                        if (isDels)
                            dels--;
                        else
                            pick--;
                    }
                    break;
                } else {
                    tmp -= arr[i];
                    arr[i] = 0;
                    if (isDels)
                        dels--;
                    else
                        pick--;
                }
            }
        }
        return dist;
    }
}