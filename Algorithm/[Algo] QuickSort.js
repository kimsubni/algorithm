function quickSort(arr, left, right) {
  if (left >= right) {
    return;
  }

  const mid = Math.floor((left + right) / 2);
  const pivot = arr[mid];
  const partition = division(arr, left, right, pivot);

  quickSort(arr, left, partition - 1);
  quickSort(arr, partition, right);

  function division(arr, left, right, pivot) {
    while (left <= right) {
      while (arr[left] < pivot) {
        left++;
      }
      while (arr[right] > pivot) {
        right--;
      }
      if (left <= right) {
        let swap = arr[left];
        arr[left] = arr[right];
        arr[right] = swap;
        left++;
        right--;
      }
    }
    return left;
  }
  return arr;
}
