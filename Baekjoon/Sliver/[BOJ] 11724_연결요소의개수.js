const input = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n");
const graph = {};

const [N, M] = input[0].split(" ").map(Number);

for (let i = 0; i < M; ++i) {
  const [U, V] = input[i + 1].split(" ").map(Number);
  graph[U] ? graph[U].push(V) : (graph[U] = [V]);
  graph[V] ? graph[V].push(U) : (graph[V] = [U]);
}

const visited = new Array(N + 1).fill(false);
let answer = 0;
for (let i = 1; i < N + 1; ++i) {
  if (visited[i]) {
    continue;
  }
  answer++;
  dfs(i);
}

function dfs(start) {
  const stack = [[start, -1]];
  while (stack.length) {
    let [cur, parent] = stack.pop();
    if (visited[cur]) {
      continue;
    }
    stack.push([cur, parent]);
    visited[cur] = true;
    if (graph[cur])
      for (const node of graph[cur]) {
        if (!visited[node]) stack.push([node, cur]);
      }
  }
}

console.log(answer);
