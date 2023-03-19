// const input = require("fs")
//   .readFileSync("/dev/stdin")
//   .toString()
//   .trim()
//   .split("\n");

const input = `1
4 3
2 3
3 4
4 2`
  .trim()
  .split("\n");
class Node {
  constructor(num, set) {
    this.num = num;
    this.set = set;
  }
}

const K = Number(input[0]);
let tIdx = 1;
let isNo;
let answer = "";
let set1, set2, graph, visited, tmpGraph;

for (let t = 0; t < K; ++t) {
  const [V, E] = input[tIdx].split(" ").map(Number);
  graph = {};
  for (let i = 1; i < V + 1; ++i) {
    graph[i] = [];
  }

  for (let i = 1; i < E + 1; ++i) {
    const [u, v] = input[tIdx + i].split(" ").map(Number);
    graph[u].push(v);
    graph[v].push(u);
  }
  isNo = false;
  visited = new Array(V + 1).fill(false);
  set1 = new Array(V + 1).fill(false);
  set2 = new Array(V + 1).fill(false);
  for (let i = 1; i < V + 1; ++i) {
    if (!visited[i] && !isNo) dfs(i);
  }
  if (isNo) {
    answer += "NO\n";
  } else {
    answer += "YES\n";
  }
  tIdx += E + 1;
}
function dfs(start) {
  const stack = [new Node(start, 1)];
  set1[start] = true;
  visited[start] = true;
  while (stack.length > 0) {
    const now = stack.pop();
    if (graph[now.num])
      for (const next of graph[now.num]) {
        if (!visited[next]) {
          now.set === 1 ? (set2[next] = true) : (set1[next] = true);
          stack.push(new Node(next, now.set === 1 ? 2 : 1));
          visited[next] = true;
        } else {
          // 방문한 곳의 set과 now.set이 같다면
          if (set1[next] && now.set === 1) {
            isNo = true;
            return;
          }
          if (set2[next] && now.set === 2) {
            isNo = true;
            return;
          }
        }
      }
  }
}

console.log(answer);
