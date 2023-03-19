const input = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n");

// const input = `9 8
// CCTGGATTG
// 2 0 1 1`
//   .trim()
//   .split("\n");

const [S, P] = input[0].split(" ").map(Number);
const DNA = input[1];
const ACGT = input[2].split(" ").map(Number);

let answer = 0;
// const count = {};
// for (let i = 0; i < N; ++i) {
//   count[DNA[i]] = count[DNA[i]] ? count[DNA[i]] + 1 : 1;
// }

let count = { A: 0, C: 0, G: 0, T: 0 };
for (let i = 0; i < P; ++i) {
  count[DNA[i]]++;
}
for (let i = 0; i < S - P + 1; ++i) {
  if (
    count["A"] >= ACGT[0] &&
    count["C"] >= ACGT[1] &&
    count["G"] >= ACGT[2] &&
    count["T"] >= ACGT[3]
  ) {
    answer++;
  }
  count[DNA[i]]--;
  count[DNA[i + P]]++;
}
console.log(answer);
