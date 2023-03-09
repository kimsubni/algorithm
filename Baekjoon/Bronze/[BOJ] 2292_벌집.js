let input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "../../input.txt")
  .toString()
  .trim()
  .split(" ");

const num = parseInt(input[0]);

let increaseNumber = 1;
let i = 1;

while (num > i) {
  i += increaseNumber * 6;
  increaseNumber++;
}

console.log(increaseNumber);
