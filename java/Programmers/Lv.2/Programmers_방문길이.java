
import java.util.HashSet;
class Programmers_방문길이 {
    public int solution(String dirs) {
        int answer = 0;
        
        HashSet<String> set = new HashSet<String>();
        
        int[][] pos = new int[2][2]; 
        
        for (int i = 0; i < dirs.length(); i++) {
			char direction = dirs.charAt(i);
			pos[1][0] = pos[0][0];
			pos[1][1] = pos[0][1];
			
			boolean flag = false;
			switch (direction) {
			case 'U':
				pos[0][1]++;
				if (pos[0][1] > 5) {
					flag = true;
					pos[0][1] = 5;
				}
				break;
			case 'D':
				pos[0][1]--;
				if (pos[0][1] < -5) {
					flag = true;
					pos[0][1] = -5;
				}
				break;
			case 'R':
				pos[0][0]++;
				if (pos[0][0] > 5) {
					flag = true;
					pos[0][0] = 5;
				}
				break;
			case 'L':
				pos[0][0]--;
				if (pos[0][0] < -5) {
					flag = true;
					pos[0][0] = -5;
				}
				break;
			default:
				break;
			}

			if (flag)
				continue;

			set.add("" + pos[0][0] + pos[0][1] + pos[1][0] + pos[1][1]);
			set.add("" + pos[1][0] + pos[1][1] + pos[0][0] + pos[0][1]);
		}
        
        answer = set.size() / 2;
        
        return answer;
    }
}