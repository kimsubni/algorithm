function quickSort(array, left = 0, right = array.length - 1) {
  if (left >= right) {
    return;
  }
  const mid = Math.floor((left + right) / 2);
  const pivot = array[mid];
  const partition = divide(array, left, right, pivot);

  quickSort(array, left, partition - 1);
  quickSort(array, partition, right);

  function divide(array, left, right, pivot) {
    console.log(
      `array: ${array}, left: ${array[left]}, pivot: ${pivot}, right: ${array[right]}`
    );
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

// const quickSortPractice = (array, left = 0, right = array.length - 1) => {
//   if (left >= right) {
//     return;
//   }
//   const mid = Math.floor((left + right) / 2);
//   const pivot = array[mid];
//   const partition = dividePractice(array, left, right);

//   quickSortPractice(array, left, partition - 1);
//   quickSortPractice(array, partition, right);

//   const dividePractice = (array, left, right) => {
//     while (left <= right) {
//       while (array[left] < pivot) {
//         left++;
//       }
//       while (array[right] > pivot) {
//         right--;
//       }
//       if (left <= right) {
//         let swap = array[left];
//         array[left] = array[right];
//         array[right] = swap;
//         left++;
//         right--;
//       }
//     }
//     return left;
//   };
//   return array;
// };

console.log(quickSort([2, 3, 5, 6, 8]));

// Not in place - Quick Sort
function quickSortNotinPlace(array) {
  if (array.length < 2) {
    return array;
  }
  const pivot = [array[0]];
  const left = [];
  const right = [];

  for (let i = 1; i < array.length; ++i) {
    if (array[i] < pivot) {
      left.push(array[i]);
    } else if (array[i] > pivot) {
      right.push(array[i]);
    } else {
      pivot.push(array[i]);
    }
  }

  console.log(`left: ${left}, pivot : ${pivot}, right : ${right}`);
  return quickSortNotinPlace(left).concat(pivot, quickSortNotinPlace(right));
}

// const sorted = quickSortNotinPlace([5, 3, 7, 1, 9]);
// console.log(sorted);

// 되게 직관적이고 좋긴하다. 그러나 공간의 낭비가 심하다는 단점이 있다.
