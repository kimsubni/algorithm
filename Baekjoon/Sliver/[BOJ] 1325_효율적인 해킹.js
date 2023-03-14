// const input = require("fs")
//   .readFileSync("/dev/stdin")
//   .toString()
//   .trim()
//   .split("\n");

const input = `5 4
3 1
3 2
4 3
5 3`
  .trim()
  .split("\n");

const [N, M] = input[0].split(" ").map(Number);
const graph = {};

for (let i = 1; i < N + 1; ++i) {
  graph[i] = [];
}
for (let i = 0; i < M; ++i) {
  const [A, B] = input[i + 1].split(" ").map(Number);
  graph[B].push(A);
}
let max = 0;
let answer = [];
const DFS = (start) => {
  const stack = [start];
  const visited = new Array(N + 1).fill(false);
  let count = 0;
  let result = 0;
  while (stack.length) {
    let cur = stack.pop();
    if (result < count) result = count;
    visited[cur] = true;
    for (let i = 0; i < graph[cur].length; i++) {
      let value = graph[cur][i];
      if (visited[value]) continue;
      visited[value] = true;
      count += 1;
      stack.push(value);
    }
  }
  if (max < result) {
    max = result;
    answer = [];
    answer.push(start);
  } else if (max === result) {
    answer.push(start);
  }
};

for (let i = 1; i <= N; i++) {
  DFS(i);
}

console.log(answer.join(" "));
