let input = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n");
const [n, m] = input[0].split(" ").map(Number);

const arr = input.slice(1, n + 1).map((str) => str.split(" ").map(Number));
const s = Array.from(new Array(n + 1), () => new Array(n + 1).fill(0));

for (let i = 1; i <= n; ++i) {
  for (let j = 1; j <= n; ++j) {
    s[i][j] = s[i - 1][j] + s[i][j - 1] - s[i - 1][j - 1] + arr[i - 1][j - 1];
  }
}
let ans = "";
for (let i = n + 1; i < input.length; ++i) {
  const [x1, y1, x2, y2] = input[i].split(" ").map(Number);
  ans +=
    String(s[x2][y2] - (s[x1 - 1][y2] + s[x2][y1 - 1]) + s[x1 - 1][y1 - 1]) +
    "\n";
}
console.log(ans);
