function solution(n) {
  var answer = 0;
  for (let i = 2; i * i <= n - 1; ++i) {
    if ((n - 1) % i === 0) {
      answer = i;
      break;
    }
  }
  if (answer === 0) answer = n - 1;
  return answer;
}

function solution2(n, x = 1) {
  while (x++) {
    if (n % x === 1) {
      return x;
    }
  }
}
// 훨씬 쉬운 방법이 있는디 왜그랬지

const solution3 = function (n) {
  for (let i = 0; i < n; i++) {
    if (n % i == 1) {
      return i;
    }
  }
};
