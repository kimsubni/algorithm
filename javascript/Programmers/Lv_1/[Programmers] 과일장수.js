function solution(k, m, score) {
  var answer = 0;
  score.sort((a, b) => b - a);
  for (let i = 0; i < score.length; ++i) {
    if ((i + 1) % m === 0) {
      answer += score[i] * m;
    }
  }
  return answer;
}

console.log(solution(4, 3, [4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2]));

function solution2(k, m, score) {
  var answer = 0;
  score.sort((a, b) => b - a);
  for (let i = m - 1; i < score.length; i += m) {
    answer += score[i] * m;
  }
  return answer;
}

solution3 = (_, m, s) =>
  s
    .sort()
    .filter((_, i) => !((s.length - i) % m))
    .reduce((a, v) => a + v, 0) * m;
