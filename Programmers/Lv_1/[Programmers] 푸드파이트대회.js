function solution(food) {
  var answer = "";
  var left = "";
  for (let num = 1; num < food.length; ++num) {
    for (let i = 1; i <= food[num] / 2; ++i) {
      left += num.toString();
    }
  }
  answer = left + "0" + left.split("").reverse().join("");
  return answer;
}

console.log(solution([1, 7, 1, 2]));

function solution2(food) {
  let res = "";
  for (let i = 1; i < food.length; i++) {
    res += String(i).repeat(Math.floor(food[i] / 2));
  }

  return res + "0" + [...res].reverse().join("");
}

function solution3(food) {
  let part = [];
  for (let i = 1; i < food.length; i++) {
    part.push(i.toString().repeat(Math.floor(food[i] / 2)));
  }

  return [part.join(""), part.reverse().join("")].join("0");
}
