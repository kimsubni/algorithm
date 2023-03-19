const input = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n");

// const input = `10 4790
// 1
// 5
// 10
// 50
// 100
// 500
// 1000
// 5000
// 10000
// 50000`
//   .trim()
//   .split("\n");

const [N, K] = input[0].split(" ").map(Number);

const arr = [];
for (let i = 1; i < N + 1; ++i) {
  arr.push(Number(input[i]));
}

let count = 0;
let tmp = K;
for (let i = N - 1; i >= 0; --i) {
  while (tmp >= arr[i]) {
    tmp -= arr[i];
    count++;
  }
}
console.log(count);

function solution2() {
  for (let i = N - 1; i >= 0; --i) {
    if (arr[i] <= K) {
      count += Math.floor(K / arr[i]);
      K = K % A[i];
    }
  }
}
