function solution(a, b, n) {
  var answer = 0;
  while (n >= a) {
    answer += parseInt(n / a) * b;
    n += (parseInt(n / a) * b) % a;
  }
  return answer;
}

console.log(solution(2, 1, 20));

const solution2 = (a, b, n) => Math.floor(Math.max(n - b, 0) / (a - b)) * b;
// 대체 이건뭘까
