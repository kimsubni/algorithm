// const input = require("fs")
//   .readFileSync("/dev/stdin")
//   .toString()
//   .trim()
//   .split("\n");
const input = `5 2
4 1 2 3 5`
  .trim()
  .split("\n");

const [N, K] = input[0].split(" ").map(Number);
const arr = input[1].split(" ").map(Number);

function quickSort1(arr) {
  let start = 0;
  let end = arr.length - 1;
  let pivot = Math.floor((start + end) / 2);

  while (start <= end) {
    if (arr[pivot] >= arr[start]) start++;
    if (arr[pivot] <= end) end--;
    // 만약 멈췄으면  start 와 end 값을 바꿔준다.
    if (arr[pivot] < start && arr[pivot] > end) {
      // 둘다 해당되면,
      let tmp = arr[start];
      arr[start] = arr[end];
      arr[end] = tmp;
    }
  }

  quickSort1(arr.slice(0, end));
  quickSort1(arr.slice(start, arr.length));
}
function quickSort(array, left, right) {
  if (left >= right) {
    return;
  }
  const mid = Math.floor((left + right) / 2);
  const pivot = array[mid];
  const partition = divide(array, left, right, pivot);

  quickSort(array, left, partition - 1);
  quickSort(array, partition, right);

  function divide(array, left, right, pivot) {
    while (left <= right) {
      while (array[left] < pivot) {
        left++;
      }
      while (array[right] > pivot) {
        right--;
      }
      if (left <= right) {
        let swap = array[left];
        array[left] = array[right];
        array[right] = swap;
        left++;
        right--;
      }
    }
    return left;
  }
  return array;
}

const answer = quickSort(arr, 0, arr.length - 1);

console.log(answer[K - 1]);
