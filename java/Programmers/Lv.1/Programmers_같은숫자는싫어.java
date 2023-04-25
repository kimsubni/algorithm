import java.util.*;

public class Programmers_같은숫자는싫어 {
    public List<Integer> solution(int[] arr) {

        List<Integer> list = new ArrayList<>();

        int temp = -1;

        for (int n : arr) {
            if (temp != n)
                list.add(n);
            temp = n;
        }

        return list;
    }
}