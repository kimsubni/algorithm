/*const input = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n");*/

const input = `5
4
3
-2
-2
-3`
  .trim()
  .split("\n");

const N = Number(input[0]);
const A = [];

// 음수에서 0이나 양수가 되는 타이밍
let idx = -1;
let isFind = false;
for (let i = 0; i < N; ++i) {
  A.push(Number(input[i + 1]));
}

A.sort((a, b) => a - b);

for (let i = 0; i < N; ++i) {
  if (A[i] >= 0 && !isFind) {
    idx = i;
    isFind = true;
  }
}
let sum = 0;
if (A.length === 1) {
  sum = A[0];
} else {
  if (idx > 0) {
    for (let i = 0; i < idx; i += 2) {
      if (i + 1 < idx) {
        sum += A[i] * A[i + 1];
      } else {
        if (A[idx] === 1) {
          sum += A[i] + A[idx];
          idx++;
        } else if (A[idx] === 0) {
          sum += A[i] * A[idx];
          idx++;
        } else {
          sum += A[i];
        }
      }
    }
    for (let i = N - 1; i >= idx; i -= 2) {
      if (i - 1 >= idx) {
        if (A[i] * A[i - 1] > A[i] + A[i - 1]) {
          sum += A[i] * A[i - 1];
        } else {
          sum += A[i] + A[i - 1];
        }
      } else {
        sum += A[i];
      }
    }
  } else {
    for (let i = N - 1; i >= 0; i -= 2) {
      if (i - 1 >= 0) {
        if (A[i] + A[i - 1] < A[i] * A[i - 1]) {
          sum += A[i] * A[i - 1];
        } else sum += A[i] + A[i - 1];
      } else {
        sum += A[i];
      }
    }
  }
}

console.log(sum);
