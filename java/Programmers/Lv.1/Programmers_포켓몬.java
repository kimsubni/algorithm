import java.util.*;

class Programmers_포켓몬 {
    public int solution(int[] nums) {
        int N = nums.length;
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < N; ++i) {
            hashSet.add(nums[i]);
            if (hashSet.size() == N / 2) {
                break;
            }
        }
        return hashSet.size();
    }
}
