// const N = Number(require("fs").readFileSync("dev/stdin").toString().trim());
const N = 15;
let s_index = 1;
let e_index = 1;
// 자기 자신일 경우를 위해 1로 초기화
let answer = 1;
let sum = 1;

while (e_index < N) {
  if (sum === N) {
    answer++;
    e_index++;
    sum += e_index;
  } else if (sum < N) {
    e_index++;
    sum += e_index;
  } else {
    sum -= s_index;
    s_index++;
  }
}

console.log(answer);
