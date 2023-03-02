const input = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n");
  
// const input = `5
// 1 5 1 -1
// 5 1 1 4 10 -1
// 4 3 10 5 10 -1
// 3 2 10 4 10 -1
// 2 3 10 -1`.trim().split("\n")

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

const graph = new Graph();
for (let i = 1; i < N + 1; ++i) {
  const now = input[i].split(" ").map(Number);
  const nowIdx = now[0];
  for (let j = 1; j < now.length; j += 2) {
    if (now[j] === -1) break;
    graph.addEdge(nowIdx, now[j], now[j + 1]);
  }
}


class Node{
  constructor(val, distance){
    this.val = val;
    this.distance = distance;
  }
}
let max = 0;
const dfs = (start, visited) => {
  const stack = [];
  stack.push(new Node(start, 0));
  while(stack.length){
    const now = stack.pop();
    if(visited[now.val]) {
      continue};

    visited[now.val] = true;
  
    max = Math.max(max, now.distance);
    
    const obj = Object.keys(graph.edges[
      now.val]);
  
    if(obj.length>0){
      for(const next of obj){
        if(!visited[next]) {
          stack.push(new Node(next, now.distance+graph.edges[now.val][next]));
          
        }
      }
    }
  }
};

for(let i =1; i <N+1; ++i){
  dfs(i,new Array(N+1).fill(false))
}

console.log(max)