function mergeSort(arr) {
  if (arr.length === 1) return arr;

  let mid = Math.floor(arr.length / 2);
  let left = arr.slice(0, mid);
  let right = arr.slice(mid, right);
  return merge(mergeSort(left), mergeSort(right));
}

function merge(left, right) {
  const resultArray = [];
  let leftIdx = 0;
  let rightIdx = 0;

  while (leftIdx < left.length && rightIdx < right.length) {
    if (left[leftIdx] < right[rightIdx]) {
      resultArray.push(left[leftIdx]);
      leftIdx++;
    } else {
      resultArray.push(right[rightIdx]);
      rightIdx++;
    }
  }
  return resultArray.concat(left.slice(leftIdx), right.slice(rightIdx));
}

const arr = [5, 4, 3, 2, 1];
// 다른방법? 로직은똑같은데 ...
const merge1 = (left, right) => {
  let arr = [];
  while (left.length && right.length) {
    if (left[0] < right[0]) arr.push(left.shift());
    else arr.push(right.shift());
  }
  return [...arr, ...left, ...right];
};

// 합병 정렬
const mergeSort1 = (array) => {
  if (array.length < 2) return array;
  const half = array.length / 2;
  const left = array.splice(0, half);
  return merge1(mergeSort1(left), mergeSort1(array));
};
console.log(mergeSort1(arr));
