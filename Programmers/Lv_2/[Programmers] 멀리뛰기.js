let num = 0;
let d = [];

function dp(x) {
  if (x == 1) return 1;
  if (x == 2) return 2;
  if (d[x] != null) return d[x];
  return (d[x] = dp(x - 1) + dp(x - 2));
}

function solution(n) {
  dp(n);
  return d[n];
}

console.log(solution(3));
