/*const input = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n");*/

const input = `4
2 3 6 8
0 1 9 3
3 0 7 5`
  .trim()
  .split("\n");

const N = Number(input[0]);
for (let i = 1; i < N + 1; ++i) {
  const now = input[i].split(" ").map(Number);
  
}
class Node {
  constructor(num, up, down) {
    this.num = num;
    this.up = up;
    this.down = down;
  }
}
