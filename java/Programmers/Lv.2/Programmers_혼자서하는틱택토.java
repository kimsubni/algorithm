
public class Programmers_혼자서하는틱택토 {
    static int N = 3;
    public int solution(String[] board) {
        int answer = -1;
        int OCnt = 0;
        int XCnt = 0;
        boolean threeO = false;
        boolean threeX = false;
        for(int i = 0; i < N; ++i){
            for(int j = 0 ; j< N; ++j){
                if(board[i].charAt(j)=='O'){
                    OCnt++;
                }else if(board[i].charAt(j) == 'X'){
                    XCnt++;
                }
            }
        }
        
        char now = board[0].charAt(0);
        if(now == board[1].charAt(1) && now == board[2].charAt(2) ){
            if(now == 'O') threeO = true;
            if(now == 'X') threeX = true;
        }
         now = board[0].charAt(2);
        if(now == board[1].charAt(1) && now == board[2].charAt(0) ){
            if(now == 'O') threeO = true;
            if(now == 'X') threeX = true;
        }
        for(int i = 0; i  < 3; ++i){
            now = board[i].charAt(0);
            if(now == board[i].charAt(1) && now == board[i].charAt(2) ){
                if(now == 'O') threeO = true;
                if(now == 'X') threeX = true;
            }
        }
        for(int i = 0; i  < 3; ++i){
            now = board[0].charAt(i);
            if(now == board[1].charAt(i) && now == board[2].charAt(i) ){
                if(now == 'O') threeO = true;
                if(now == 'X') threeX = true;
            }
        }
        if(OCnt == XCnt +1 || OCnt == XCnt){
             if(OCnt == XCnt+1 && threeX){
                return 0;
            }
            if(OCnt == XCnt){
                if(threeO) return 0;
            }
            return 1;
        }else{
            return 0;
        }
       
    }
}

