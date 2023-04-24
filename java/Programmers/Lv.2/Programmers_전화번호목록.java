import java.util.*;

class Programmers_전화번호목록 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        HashSet<String> set = new HashSet<>();
        for (String str : phone_book) {
            if (set.size() == 0) {
                set.add(str);
            } else {
                for (int i = 1; i <= str.length(); ++i) {
                    if (set.contains(str.substring(0, i))) {
                        return false;
                    }
                }
                set.add(str);
            }
        }
        return answer;
    }
}
