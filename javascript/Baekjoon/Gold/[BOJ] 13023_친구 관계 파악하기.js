/*const input = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n");*/
const input = `5 5
0 1
0 2
1 2
2 3
3 4`
  .trim()
  .split("\n");

const [N, M] = input[0].split(" ").map(Number);

/*class Node {
  constructor(num, count, visited) {
    this.num = num;
    this.count = count;
    this.visited = visited;
  }
}*/

const graph = {};
const visited = new Array(N).fill(false);
let arrive = false;

for (let i = 0; i < M; ++i) {
  const [a, b] = input[i + 1].split(" ").map(Number);
  graph[a] ? graph[a].push(b) : (graph[a] = [b]);
  graph[b] ? graph[b].push(a) : (graph[b] = [a]);
}
let answer = 0;

const dfs = (now, depth) => {
  if (depth === 5 || arrive) {
    arrive = true;
    answer = 1;
    return;
  }

  visited[now] = true;
  if (graph[now]) {
    for (const next of graph[now]) {
      !visited[next] && dfs(next, depth + 1);
    }
  }
  visited[now] = false;
};

for (let i = 0; i < N; ++i) {
  dfs(i, 1);
  if (arrive) break;
}

console.log(answer);

/*const dfs = (start) => {
  const stack = [];
  stack.push(start);

  while (stack.length) {
    const now = stack.pop();
    if (now.count === 5) {
      answer = 1;
      return;
    }
    now.visited[now.num] = true;
    if (graph[now.num]) {
      for (const node of graph[now.num]) {
        if (!now.visited[node]) {
          stack.push(new Node(node, now.count + 1, [...now.visited]));
        }
      }
    }
  }
};*/
