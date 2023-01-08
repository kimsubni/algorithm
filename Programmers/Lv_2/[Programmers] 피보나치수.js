let dp = [];
dp[0] = 0;
dp[1] = 1;

function solution(n) {
  if (n === 1) return 1;
  if (n === 2) return 1;
  if (dp[n]) return dp[n];
  return (dp[n] = solution(n - 1) + solution(n - 2)) % 1234567;
}

function solution2(n) {
  for (let i = 2; i <= n; ++i) {
    dp[i] = dp[i - 1] + dp[i - 2];
  }
  return dp[n];
}

console.log(solution2(5));
