import java.util.*;

public class Programmers_신고결과받기 {
    // set을 담는 List 생성
    static List< HashSet<Integer> > setList = new ArrayList<>();

    public int[] solution(String[] id_list, String[] report, int k) {
        
        // 이름 | index로 구성 된 Map을 생성
        Map<String,Integer> idMap = new HashMap<>();
        for(int i=0; i<id_list.length; i++) idMap.put( id_list[i], i );  

        // set List 초기화 (유저 수 만큼 set을 담은 리스트 생성)
        setList.clear();
        for(int i=0; i<id_list.length; i++) setList.add(new HashSet<Integer>());

        StringTokenizer st;
        String userId, reportedId;
        for(String str : report){
            st = new StringTokenizer(str);
            userId = st.nextToken();
            reportedId = st.nextToken();
            
            // List(0)의 set에는 0을 신고한 유저 index가 저장
            setList.get( idMap.get(reportedId) ).add( idMap.get(userId) );
        }

        int[] answer = new int[id_list.length];

        for(int i=0; i<id_list.length; i++){
            // i 유저를 신고한 인원 = set의 사이즈
            // set size가 k보다 크면 메일이 발송됨
            // set안에 i를 신고한 유저 번호이므로 answer 배열에 1씩 더해 줌
            if( setList.get(i).size() >= k ){
                for( int reportMan : setList.get(i) ) answer[reportMan]++;
            }
        }

        return answer;
    }
}