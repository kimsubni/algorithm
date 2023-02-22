const input = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n");

/*const input = `5
1
2
5
3
4`
  .trim()
  .split("\n");*/

const N = Number(input[0]);

let answer = "";
const stack = [];
let num = 1;
for (let i = 1; i < N + 1; ++i) {
  let now = Number(input[i]);
  if (num <= now) {
    while (num <= now) {
      stack.push(num++);
      answer += "+\n";
    }
    stack.pop();
    answer += "-\n";
  } else {
    let n = stack.pop();
    if (n > now) {
      answer = "NO";
      break;
    } else {
      answer += "-\n";
    }
  }
}
console.log(answer);
