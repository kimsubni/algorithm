const input = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n");

// const input = `5 20
// 4 42 40 26 46`
//   .trim()
//   .split("\n");

const [N, M] = input[0].split(" ").map(Number);

const arr = input[1].split(" ").map(Number);

arr.sort((a, b) => a - b);

let left = 1;
let right = arr[N - 1];
let result = 0;

while (left <= right) {
  let mid = Math.floor((left + right) / 2);

  let sum = 0;
  for (let i = 0; i < N; ++i) {
    if (arr[i] - mid > 0) sum += arr[i] - mid;
  }
  if (sum >= M) {
    result = Math.max(result, mid);
    left = mid + 1;
  } else {
    right = mid - 1;
  }
}

console.log(result);
