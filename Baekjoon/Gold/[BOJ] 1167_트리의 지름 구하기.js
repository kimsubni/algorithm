// const input = require("fs")
//   .readFileSync("/dev/stdin")
//   .toString()
//   .trim()
//   .split("\n");

// const N = Number(input[0]);
const N = 4;

let graph = [];

for (let i = 0; i < N; ++i) {
  graph[i] = {};
}
console.log(graph);

for (let i = 1; i < N + 1; ++i) {
  const now = input[i].split(" ").map(Number);
  for (let j = 0; j < now.length; j += 3) {
    if (now[j] === -1) break;
    //  연결 그래프
  }
}

const dfs = () => {};
