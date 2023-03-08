//const input = require("fs").readFileSync("/dev/stdin").toString().trim();

// 어떤 수가 소수의 N제곱 꼴일때, 그 수를 거의 소수라고 한다.
// 두 정수 A와 B가 주어지면, A보다 크거나 같고, B보다 작거나 같은 거의 소수가 몇개인지?
const [A, B] = input.split(" ").map(Number);
const num = [];
num[0] = true;
let count = 0;
for (let i = 2; i <= Math.sqrt(B); ++i) {
  if (num[i]) continue;
  for (let j = i + i; j <= B; j += i) {
    num[j] = true;
  }
}

for (let i = 2; i <= Math.sqrt(B); ++i) {
  if (!num[i]) {
    let temp = i;
    while (i <= B / temp) {
      if (i >= A / temp) {
        count++;
      }
      temp = temp * i;
    }
  }
}
console.log(count);
