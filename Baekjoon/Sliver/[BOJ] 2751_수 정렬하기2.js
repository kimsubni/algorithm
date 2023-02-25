const input = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n");
// const input = `5
// 5
// 4
// 3
// 2
// 1`
//   .trim()
//   .split("\n");

const N = Number(input[0]);
const arr = [];

for (let i = 0; i < N; ++i) {
  arr.push(Number(input[i + 1]));
}

function merge(left, right) {
  const resultArray = [];
  let leftIndex = 0;
  let rightIndex = 0;

  while (leftIndex < left.length && rightIndex < right.length) {
    if (left[leftIndex] < right[rightIndex]) {
      resultArray.push(left[leftIndex]);
      leftIndex++;
    } else {
      resultArray.push(right[rightIndex]);
      rightIndex++;
    }
  }

  return resultArray.concat(left.slice(leftIndex), right.slice(rightIndex));
}

const mergeSort = (arr) => {
  if (arr.length === 1) {
    return arr;
  }
  const middleIdx = Math.floor(arr.length / 2);
  const left = arr.slice(0, middleIdx);
  const right = arr.slice(middleIdx);

  return merge(mergeSort(left), mergeSort(right));
};

const sortArr = mergeSort(arr);

let answer = "";
for (let i = 0; i < N; ++i) {
  answer += sortArr[i] + "\n";
}

console.log(answer);
