function solution(board) {
  const row = board.length;
  const col = board[0].length;
  const maxN = row <= col ? row : col;
  const sum = Array.from(new Array(row), () => new Array(col).fill(0));

  let max = 0;
  for (let i = 0; i < row; ++i) {
    for (let j = 0; j < col; ++j) {
      sum[i][j] =
        (i - 1 >= 0 && sum[i - 1][j]) +
        (j - 1 >= 0 && sum[i][j - 1]) +
        board[i][j] -
        (i - 1 >= 0 && j - 1 >= 0 && sum[i - 1][j - 1]);
    }
  }

  for (let i = row - 1; i >= 0; --i) {
    if (Math.sqrt(max) >= i) break;
    for (let j = col - 1; j >= 0; --j) {
      if (Math.sqrt(max) >= j) break;
      for (let n = maxN; n >= 1; --n) {
        if (Math.sqrt(max) >= maxN) break;
        const num =
          sum[i][j] -
          (i - n >= 0 && sum[i - n][j]) -
          (j - n >= 0 && sum[i][j - n]) +
          (i - n >= 0 && j - n >= 0 && sum[i - n][j - n]);
        if (Math.sqrt(num) % 1 === 0) {
          max = max > num ? max : num;
          console.log("출력해보아라.", max);
        }
      }
    }
  }
  console.log(sum);
  return max;
}

console.log(
  solution([
    [0, 1, 1, 1],
    [1, 1, 1, 1],
    [1, 1, 1, 1],
    [0, 0, 1, 0],
  ])
);
/*
 [ 0, 1, 2, 3 ]
 [ 1, 3, 5, 7 ]
 [ 2, 5, 8, 11 ]
 [ 2, 5, 9, 12 ]
*/
