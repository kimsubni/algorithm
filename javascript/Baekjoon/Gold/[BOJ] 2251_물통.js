const input = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n");

const [A, B, C] = input[0].map(Number);
// 각각의 부피가 A,B,C 리터인 세개의 물통이 있다.
// 처음에는 