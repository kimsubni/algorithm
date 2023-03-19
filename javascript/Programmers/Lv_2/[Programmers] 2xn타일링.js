let rect = [];
rect[1] = 1;
rect[2] = 2;
function solution(n) {
  for (let i = 3; i <= n; ++i) {
    rect[i] = (rect[i - 1] + rect[i - 2]) % 1000000007;
  }
  return rect[n];
}
console.log(solution(4));
