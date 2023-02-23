const input = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n");

const N = Number(input[0]);
const arr = [];
for (let i = 0; i < N; ++i) {
  arr.push(Number(input[i + 1]));
}

for (let i = 0; i < N; ++i) {
  for (let j = 1; j < N - i; ++j) {
    if (arr[j - 1] > arr[j]) {
      let tmp = arr[j - 1];
      arr[j - 1] = arr[j];
      arr[j] = tmp;
    }
  }
}

let answer = "";
for (let i = 0; i < N; ++i) {
  answer += arr[i] + " ";
}
console.log(answer);
