function solution(t, p) {
  var answer = 0;
  for (let i = 0; i < t.length - p.length + 1; ++i) {
    if (Number(t.slice(i, i + p.length)) <= Number(p)) {
      answer++;
    }
  }
  return answer;
}

console.log("answer : " + solution("10203", "15"));
function solution2(t, p) {
  let count = 0;
  for (let i = 0; i <= t.length - p.length; i++) {
    let value = t.slice(i, i + p.length);
    if (+p >= +value) count++;
  }
  return count;
}
