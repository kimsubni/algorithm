#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

bool cmp(vector<int> &v1, vector<int> &v2){
  if(v1[0] == v2[0])
    return v1[1]<v2[1];
  else return v1[0]<v2[0];
}

int solution(vector<vector<int>> targets) {
    sort(targets.begin(), targets.end(), cmp);
    
    int answer = 1;
    int end = INT32_MAX;
    for(int i = 0; i < targets.size()-1; ++i){
        int s = targets[i][0];
        int e = targets[i][1];
        end = min(e, end);
        if(end > targets[i+1][0]){
            continue;
        }else{
            end = INT32_MAX;
            answer= answer+1;
        }
        cout << endl;
    }
    return answer;
}
