const input = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n");

// 세준이는 크기가 N*N인 배열 A를 만들었다. 배열에 들어있는 수 A[i][j] = j*i 이다.
// 이 수를 일차원배열 B에 넣으면 B의 크기는 N*N이 된다. B를 오름차순정렬했을 때, B[k]를 구해보자.

const N = Number(input[0]);
const K = Number(input[1]);

let left = 1;
let right = K;

while (left < right) {
  let mid = Math.floor((left + right) / 2);
  let now = 0;
  for (let i = 1; i < N + 1; ++i) {
    now += Math.min(Math.floor(mid / i), N);
  }
  if (K <= now) {
    right = mid;
  } else {
    left = mid + 1;
  }
}

console.log(left);
