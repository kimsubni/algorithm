#include <string>
#include <vector>
#include <iostream>
#include <queue>

using namespace std;
vector<int> dr = {-1, 0, 1, 0};
vector<int> dc = {0,1, 0,-1};
class Pos{
 public :
    int r;
    int c;
    int cnt;
    Pos(int r, int c, int cnt) {
        this-> r = r;
        this-> c = c;
        this-> cnt = cnt;
    }
};
bool findAns;
int answer;
void bfs(int r, int c, vector<string> maps, int cnt, bool flag){
    queue<Pos> q;
    int visited[maps.size()][maps[0].size()];
    for(int i =0 ;i < maps.size(); ++i){
        for(int j = 0; j < maps[i].size(); ++j){
            visited[i][j]= 0;
        }
    }
    q.push(Pos(r,c,cnt));
    visited[r][c] = 1;
    while(!q.empty()){
        Pos now = q.front();
        q.pop();
        if(maps[now.r].at(now.c)=='L' && !flag){
            bfs(now.r, now.c, maps, now.cnt, true);
            return;
        }
        if(maps[now.r].at(now.c)=='E' && flag){
            answer = now.cnt;
            findAns = true;
            return;
        }
        for(int i = 0; i < 4; ++i){
            int nr = now.r + dr[i];
            int nc = now.c + dc[i];
            if(nr >= maps.size() || nc >= maps[0].size() || nr < 0 || nc < 0) continue;
            if(visited[nr][nc] == 0 && maps[nr].at(nc)!='X'){
                visited[nr][nc] = 1;
                q.push(Pos(nr,nc,now.cnt+1));
            }
        }
    }
}
int solution(vector<string> maps) {
    bool start = false;
    for(int i = 0; i < maps.size(); ++i){
        for(int j = 0; j < maps[i].size(); ++j){
            if(maps[i].at(j)=='S'){
                bfs(i, j, maps, 0, false);
                break;
            }
        }
        if(start) break;
    }
    if(!findAns) answer = -1;
    return answer;
}
