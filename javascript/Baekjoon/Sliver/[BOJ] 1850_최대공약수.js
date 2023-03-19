//const input = require("fs").readFileSync("/dev/stdin").toString().trim();

const input = "3 6";
const [A, B] = input.split(" ").map(BigInt);

// const input = "3 6";
let result = 0;
function solution(a, b) {
  if (b == 0) {
    result = a;
  } else {
    solution(b, a % b);
  }
}
solution(A, B);
let answer = "";

for (let i = 0; i < result; ++i) {
  answer += "1";
}
console.log(answer);
