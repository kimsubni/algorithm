const input = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n");

// const input = `4
// 9 5 4 8`
//   .trim()
//   .split("\n");

const N = Number(input[0]);

const arr = input[1].split(" ").map(Number);
const stack = [];

const result = [];
let answer = "";

for (let i = 0; i < N; ++i) {
  let now = arr[i];
  while (stack.length > 0 && stack[stack.length - 1].value < now) {
    const tmp = stack.pop();
    result[tmp.index] = result[tmp.index] ? result[tmp.index] : now;
  }
  stack.push({ value: now, index: i });
}

for (let i = 0; i < N; ++i) {
  result[i] = result[i] ? result[i] : -1;
  answer += result[i] + " ";
}

console.log(answer.trimEnd());
