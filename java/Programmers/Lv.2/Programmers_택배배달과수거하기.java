
public class Programmers_택배배달과수거하기 {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int dels = 0;
        int pick = 0;
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
            int tmp = cap;
            boolean flag = false;
            if (dels > 0) {
                for (int i = n - 1; i >= 0; --i) {
                    if (deliveries[i] > 0) {
                        flag = true;
                        // 만약 배달할게 있으면
                        dist = Math.max(dist, i + 1);
                        if (deliveries[i] >= tmp) {
                            // 그러면 그냥 다 배달완료!
                            deliveries[i] -= tmp;
                            tmp = 0;
                            if (deliveries[i] == 0)
                                dels--;
                            break;
                        } else {
                            // tmp가 더 크니깐...
                            tmp -= deliveries[i];
                            deliveries[i] = 0;
                            dels--;
                        }
                    }
                }
            }
            tmp = cap;
            if (pick > 0) {
                for (int i = n - 1; i >= 0; --i) {
                    if (pickups[i] > 0) {
                        flag = true;
                        // 만약 수거할게 있으면.
                        dist = Math.max(dist, i + 1);
                        if (pickups[i] >= tmp) {
                            // 그러면 그냥 다 배달완료!
                            pickups[i] -= tmp;
                            if (pickups[i] == 0)
                                pick--;
                            break;
                        } else {
                            tmp -= pickups[i];
                            pickups[i] = 0;
                            pick--;
                        }
                    }
                }
            }
            if (!flag) {
                break;
            }
            answer += dist * 2;
        }
        return answer;
    }
}