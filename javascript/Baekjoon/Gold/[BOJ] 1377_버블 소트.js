const input = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n");

const N = Number(input[0]);
const arr = [];

class Node {
  constructor(val, index) {
    this.val = val;
    this.index = index;
  }
}

for (let i = 0; i < N; ++i) {
  arr.push(new Node(Number(input[i + 1]), i));
}

arr.sort((a, b) => a.val - b.val);

let max = 0;
let gap;
for (let i = 0; i < N; ++i) {
  gap = arr[i].index - i;
  max = Math.max(max, gap);
}

console.log(max + 1);
