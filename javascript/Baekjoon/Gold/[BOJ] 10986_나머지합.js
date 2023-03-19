let input = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n");
// let input = `5 3
// 1 2 3 1 2`
//   .trim()
//   .split("\n");
const [n, m] = input[0].split(" ").map(Number);

const arr = input[1].split(" ").map(Number);

const sum = [];
const count = new Array(m).fill(0);
sum[0] = arr[0];

for (let i = 1; i < n; ++i) {
  sum[i] = arr[i] + sum[i - 1];
}

let answer = 0;
for (let i = 0; i < n; ++i) {
  let remainder = sum[i] % m;
  if (remainder === 0) answer++;
  count[remainder]++;
}

for (let i = 0; i < m; ++i) {
  if (count[i] > 1) answer += (count[i] * (count[i] - 1)) / 2;
}

console.log(answer);
