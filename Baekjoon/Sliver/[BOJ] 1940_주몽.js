const input = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n");

// const input = `3
// 4
// 1 2 3`
//   .trim()
//   .split("\n");

// 재료의 개수 N, 갑옷만드는데 필요한 수 M
const N = Number(input[0]);
const M = Number(input[1]);
let count = 0;

const arr = input[2].split(" ").map(Number);
const isExist = {};
for (let i = 0; i < N; ++i) {
  isExist[arr[i]] = true;
}

// 중복을 고려하지않았다.
for (let i = 0; i < N; ++i) {
  if (isExist[M - arr[i]] && arr[i] + arr[i] !== M) {
    count++;
    isExist[arr[i]] = false;
  }
}

console.log(count);
