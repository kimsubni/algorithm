let input = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n");

// const input = `4 0
// 2 -2 2 -2`
//   .trim()
//   .split("\n");

const [N, K] = input[0].split(" ").map(Number);
const arr = input[1].split(" ").map(Number);

const sum = [];
sum[0] = arr[0];
let answer = 0;

for (let i = 1; i < N; ++i) {
  sum[i] = sum[i - 1] + arr[i];
}
console.log(sum);

let map = new Map();
for (let i = 0; i < N; ++i) {
  if (sum[i] === K) {
    answer++;
  }
  if (map.has(sum[i] - K)) answer += map.get(sum[i] - K);
  // 누적합을 map에 추가해주기
  if (map.has(sum[i])) {
    map.set(sum[i], map.get(sum[i]) + 1);
  } else {
    map.set(sum[i], 1);
  }
}

console.log(answer);
