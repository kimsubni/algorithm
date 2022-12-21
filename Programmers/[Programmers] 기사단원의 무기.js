function solution(number, limit, power) {
  var answer = 0;
  var divisor = {};
  for (let num = 1; num <= number; ++num) {
    divisor[num] = 0;
    for (let j = 1; j * j <= num; ++j) {
      if (num % j === 0) {
        divisor += j * j !== num ? 2 : 1;
      }
      if (divisor[num] > limit) {
        divisor[num] = power;
        break;
      }
    }
    answer += divisor[num];
  }

  console.log(divisor);
  return answer;
}

console.log(solution(10, 3, 2));

//------------------------------------------------------------------------------------------------
function solution2(number, limit, power) {
  const sum = (num) => {
    let res = 0;
    for (let i = 1; i * i <= num; i++) {
      if (i * i === num) res++;
      else if (num % i === 0) res += 2;
    }
    return res;
  };
  return Array.from({ length: number }, (el, i) => i + 1)
    .map((el) => (sum(el) > limit ? power : sum(el)))
    .reduce((acc, cur) => acc + cur, 0);
}

//------------------------------------------------------------------------------------------------
const countOdds = (num) => {
  let cnt = Number.isInteger(Math.sqrt(num)) ? 1 : 0;
  for (let i = 1; i < Math.sqrt(num); i++) {
    if (num % i == 0) {
      cnt += 2;
    }
  }
  return cnt;
};
function solution3(number, limit, power) {
  let lst = Array.from(Array(number), (v, i) => countOdds(i + 1));
  return lst.reduce((acc, val) => acc + (val > limit ? power : val), 0);
}

//------------------------------------------------------------------------------------------------
const getDivisorLength = (n) => {
  let length = 0;
  for (let i = 1; i * i <= n; i++)
    if (n % i === 0) length += i * i === n ? 1 : 2;
  return length;
};
const solution4 = (number, limit, power) => {
  const divisorLengths = [];
  for (let i = 1; i <= number; i++) divisorLengths.push(getDivisorLength(i));
  const answer = divisorLengths
    .map((length) => (length > limit ? power : length))
    .reduce((p, c) => (p += c), 0);
  return answer;
};

//------------------------------------------------------------------------------------------------
