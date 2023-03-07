//const input = require("fs").readFileSync("/dev/stdin").toString().trim();

const input = "1 2";
const [M, N] = input.split(" ").map(Number);

const arr = new Array(N + 1).fill(false);

arr[1] = true;

for (let i = 2; i <= Math.sqrt(N); ++i) {
  if (arr[i]) continue;
  for (let j = i + i; j <= N; j += i) {
    arr[j] = true;
  }
}
let answer = "";
for (let i = M; i <= N; ++i) {
  if (!arr[i]) {
    answer += i + `\n`;
  }
}
console.log(answer);
