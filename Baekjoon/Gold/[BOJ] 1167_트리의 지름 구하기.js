// const input = require("fs")
//   .readFileSync("/dev/stdin")
//   .toString()
//   .trim()
//   .split("\n");
  
const input = `5
1 5 1 -1
5 1 1 4 10 -1
4 3 10 5 10 -1
3 2 10 4 10 -1
2 3 10 -1`.trim().split("\n")

// const input = `5
// 1 3 2 -1
// 2 4 4 -1
// 3 1 2 4 3 -1
// 4 2 4 3 3 5 6 -1
// 5 4 6 -1`.trim().split("\n")

const N = Number(input[0]);

class Graph {
  constructor() {
    this.edges = {};
  }
  // 정점 추가하기
  addVertex(vertex) {
    this.edges[vertex] = {};
  }
  // 간선 추가하기
  addEdge(vertex1, vertex2, weigh) {
    if (weigh === undefined) {
      weigh = 0;
    }
    if(this.edges[vertex1]){
      this.edges[vertex1][vertex2] = weigh;
    }else{
      this.addVertex(vertex1);
      this.edges[vertex1][vertex2] = weigh;
    }
    if(this.edges[vertex2]){
      this.edges[vertex2][vertex1] = weigh;
    }else{
      this.addVertex(vertex2);
      this.edges[vertex2][vertex1] = weigh;
    }
  }
  // 간선 삭제하기
  removeEdge(vertex1, vertex2) {
    if (this.edges[vertex1] && this.edges[vertex1][vertex2] !== undefined) {
      delete this.edges[vertex1][vertex2];
    }
    if (this.edges[vertex2] && this.edges[vertex2][vertex1] !== undefined) {
      delete this.edges[vertex2][vertex1];
    }
  }

  // 정점 삭제하기
  removeVertex(vertex) {
    for (let adjacentVertex in this.edges[vertex]) {
      this.removeEdge(adjacentVertex, vertex);
    }
    delete this.edges[vertex];
  }
}
const startNodeidx = [];
const graph = new Graph();
for (let i = 1; i < N + 1; ++i) {
  const now = input[i].split(" ").map(Number);
  const nowIdx = now[0];
  if(now.length===4){
    startNodeidx.push(nowIdx);
  }
  for (let j = 1; j < now.length; j += 2) {
    if (now[j] === -1) break;
    graph.addEdge(nowIdx, now[j], now[j + 1]);
  }
}

let visited = new Array(N+1).fill(false);
let distance = new Array(N+1).fill(0);

const dfs = (start) => {
  const stack = [];
  stack.push(start);
  while(stack.length){
    const now = stack.pop();
    if(visited[now]) {
      continue};

    visited[now] = true;
  
  
      for(const next in graph.edges[now]){
        if(!visited[next]) {
          stack.push(next);
          distance[next] = distance[now] +  graph.edges[now][next];
      }
    }
  }
};
  dfs(1)
  let maxIdx = 1;
  for(let i = 2; i < N+1; ++i){
    if(distance[maxIdx] <distance[i]){
      maxIdx = i;
    }
  }
  distance = new Array(N+1).fill(0);
  visited = new Array(N+1).fill(false);
  dfs(maxIdx);
  
  distance.sort((a,b)=>a-b);
  

console.log(distance[N])