#include <string>
#include <vector>
#include <iostream>


using namespace std;
int len, N;
int answer = INT32_MAX;
vector<vector<int>> graph = {{1,1,1}, {5,1,1}, {25, 5, 1}};
void recur(int idx, int fatigue, int d, int i, int s, vector<vector<int>> sum){
    if(idx == len || (d == 0 && s == 0 && i == 0)){
        answer = min(answer,fatigue);
        return;
    }
    
    if(d>0){
         recur(idx + 1, fatigue + sum[0][idx], d - 1, i, s, sum);
    }
    if(i>0){
        recur(idx + 1, fatigue + sum[1][idx], d, i - 1, s, sum);
    }
    if(s>0){
         recur(idx + 1, fatigue + sum[2][idx], d, i, s - 1, sum);
    }
}
int solution(vector<int> picks, vector<string> minerals) {
    if(minerals.size() %5 == 0){
        len = minerals.size()/5;
    }else{
        len = minerals.size()/5 + 1;
    }
    N = minerals.size();
    
    vector<vector<int>> sum(3,vector<int>(len));
    for(int i = 0; i < 3; ++i){
        int idx = 0;
        for(int j = 0; j < N; ++j){
            if(j%5 == 0 && j != 0){
                idx++;
            }
            if(minerals[j].compare("diamond")==0){
                sum[i][idx] += graph[i][0];
            }else if(minerals[j].compare("iron")==0){
                sum[i][idx] += graph[i][1];
            } else {
                sum[i][idx] += graph[i][2];
            }
        }
    }
    recur(0, 0, picks[0], picks[1], picks[2], sum);
    
    return answer;
}

