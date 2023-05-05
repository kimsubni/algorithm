#include <string>
#include <vector>
#include <algorithm>
#include <queue>
#include <stack>
#include <iostream>
#include <sstream>


using namespace std;

struct Hw{
    string name;
    int start;
    int play;
};

struct cmp{
    bool operator()(Hw o1, Hw o2){
        return o1.start > o2.start;
    }
};
priority_queue<Hw, vector<Hw>, cmp> pq;
stack<Hw> rest;
vector<string> answer;
void run(Hw now, int nextT){
    int doneT = now.start + now.play;
    if(doneT > nextT){
        now.play = doneT - nextT;
        rest.push(now);
    }else{
        answer.push_back(now.name);
        if(doneT == nextT){
            return;
        }else if(!rest.empty()){
            now = rest.top();
            rest.pop();
            now.start = doneT;
            run(now, nextT);
        }
    }
}


vector<string> split(string input, char d){
    stringstream ss(input);
    vector<string> result;
    string tmp;
    while(getline(ss, tmp, d)){
        result.push_back(tmp);
    }
    return result;
}

vector<string> solution(vector<vector<string>> plans){
    
    for(int i = 0; i < plans.size(); ++i){
        Hw hw;
        hw.name = plans[i][0];
        hw.start = stoi(split(plans[i][1], ':')[0]) * 60 + stoi(split(plans[i][1], ':')[1]);
        hw.play = stoi(plans[i][2]);
        pq.push(hw);
    }
    while(!pq.empty()){
        Hw now = pq.top();
        pq.pop();
        if(pq.empty()){
            run(now, INT32_MAX);
        }else{
            run(now, pq.top().start);
        }
    }
    return answer;
}