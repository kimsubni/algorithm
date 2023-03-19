/*const input = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n");

*/

const input = `10-0-0+1`;

const arr = input.split("-");

const mySum = (string) => {
  let numArr = string.split("+");
  let sum = 0;
  for (let i = 0; i < numArr.length; ++i) {
    sum += Number(numArr[i]);
  }
  return Number(sum);
};

let answer = 0;

for (let i = 0; i < arr.length; ++i) {
  let value = mySum(arr[i]);
  if (i !== 0) answer -= Number(value);
  else answer += Number(value);
}
console.log(Number(answer));
