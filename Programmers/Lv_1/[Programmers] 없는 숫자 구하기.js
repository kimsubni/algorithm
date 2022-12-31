function solution(numbers) {
  answer = -1;
  let num = [];
  for (let i = 0; i < 10; ++i) {
    num[i] = false;
  }
  for (let i = 0; i < numbers.length; ++i) {
    if ("0123456789".includes(numbers[i])) {
      num[Number(numbers[i])] = true;
    }
  }
  for (let i = 0; i < 10; ++i) {
    if (!num[i]) answer += answer === -1 ? i + 1 : i;
  }
  return answer;
}

console.log(solution([5, 8, 4, 0, 6, 7, 9]));

function solution2(numbers) {
  return 45 - numbers.reduce((cur, acc) => cur + acc, 0);
}
