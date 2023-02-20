const input = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n");

// const input = `10
// 1 2 3 4 5 6 7 8 9 10`
//   .trim()
//   .split("\n");

const N = Number(input[0]);
const arr = input[1].split(" ").map(Number);

let count = 0;
const map = new Map();
for (let i = 0; i < N; ++i) {
  map.has(arr[i]) ? map.set(arr[i], map.get(arr[i]) + 1) : map.set(arr[i], 1);
}
for (let i = 0; i < N; ++i) {
  for (let j = 0; j < N; ++j) {
    if (map.has(arr[i] - arr[j]) && map.get(arr[i] - arr[j]) > 0) {
      if (arr[j] + arr[j] === arr[i]) {
        if (map.get(arr[j]) >= 2) {
          i !== k && j !== k && count++;
          break;
        } else {
          continue;
        }
      } else {
        count++;
        break;
      }
    }
  }
}

console.log(count);

// 풀이가 너무 더럽다.

const solution = () => {
  let count = 0;
  arr.sort((a, b) => a - b);
  for (let i = 0; i < N; ++i) {
    let left = 0;
    let right = N - 1;
    while (i < j) {
      if (arr[left] + arr[right] === arr[i]) {
        if (left !== i && right !== i) {
          count++;
          break;
        } else if (left === i) left++;
        else if (right === i) right--;
      } else if (arr[left] + arr[right] < arr[i]) {
        left++;
      } else right--;
    }
  }
  return count;
};

console.log(solution());
