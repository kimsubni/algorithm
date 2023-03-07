/*const input = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n");*/
const input = `3
3 3
3 4
1 3`
  .trim()
  .split("\n");

class Node {
  constructor(start, end) {
    this.start = start;
    this.end = end;
  }
}

const N = Number(input[0]);
const arr = [];
for (let i = 0; i < N; ++i) {
  const [start, end] = input[i + 1].split(" ").map(Number);
  arr.push(new Node(start, end));
}

arr.sort((a, b) => {
  if (a.end - b.end !== 0) {
    return a.end - b.end;
  } else {
    return a.start - b.start;
  }
});

let prev = arr[0].end;
let count = 1;
for (let i = 1; i < N; ++i) {
  const now = arr[i];
  if (prev <= now.start) {
    count++;
    prev = now.end;
  }
}
console.log(count);
