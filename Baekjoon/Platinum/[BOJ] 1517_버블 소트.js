const input = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n");

const N = Number(input[0]);
const arr = input[1].split(" ").map(Number);
let answer = 0;

// 여기서 일단 분할정복을. .

const mergeSort = (arr) => {
  if (arr.length === 1) {
    return arr;
  }

  let mid = Math.floor(arr.length / 2);
  let left = arr.slice(0, mid);
  let right = arr.slice(mid);

  return merge(mergeSort(left), mergeSort(right));
};

const merge = (left, right) => {
  let resultArr = [];
  let leftIdx = 0;
  let rightIdx = 0;

  while (leftIdx < left.length && rightIdx < right.length) {
    if (left[leftIdx] <= right[rightIdx]) {
      resultArr.push(left[leftIdx]);
      leftIdx++;
    } else {
      resultArr.push(right[rightIdx]);
      rightIdx++;
      answer += left.length - leftIdx;
    }
  }
  return resultArr.concat(left.slice(leftIdx), right.slice(rightIdx));
};
mergeSort(arr);
console.log(answer);
