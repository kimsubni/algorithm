const input = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n");

// const input = `5 3
// 1
// 2
// 8
// 4
// 9`
//   .trim()
//   .split("\n");

const [N, C] = input[0].split(" ").map(Number);

const arr = [];
for (let i = 1; i < N + 1; ++i) {
  arr.push(Number(input[i]));
}
arr.sort((a, b) => a - b);

let left = 1;
let right = arr[N - 1];
let result = 0;

const isPossible = (dis) => {
  let cnt = 1;
  // 첫번쨰는 무조건 포함
  let prev = arr[0];
  for (let i = 1; i < N; ++i) {
    if (arr[i] - prev >= dis) {
      cnt++;
      prev = arr[i];
    }
  }
  if (cnt >= C) {
    return true;
  }
  return false;
};

while (left <= right) {
  let mid = Math.floor((left + right) / 2);
  if (isPossible(mid)) {
    result = Math.max(result, mid);
    left = mid + 1;
  } else {
    right = mid - 1;
  }
}

console.log(result);
