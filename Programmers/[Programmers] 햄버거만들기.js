function solution(ingredient) {
  var answer = 0;
  var i = 0;
  var bread = [];
  while (true) {
    if (ingredient.length - 1 === i || ingredient.length < 4) {
      break;
    }
    if (ingredient[i] === 1) {
      if (
        ingredient[i + 1] === 2 &&
        ingredient[i + 2] === 3 &&
        ingredient[i + 3] === 1
      ) {
        answer++;
        ingredient.splice(i, 4);
        i = bread.length > 0 ? bread.pop() - 1 : -1;
      } else {
        bread.push(i);
      }
    }
    i++;
  }
  return answer;
}

console.log(solution([2, 1, 1, 2, 3, 1, 2, 3, 1]));

function solution(ingredient) {
  let count = 0;

  for (let i = 0; i < ingredient.length; i++) {
    if (ingredient.slice(i, i + 4).join("") === "1231") {
      count++;
      ingredient.splice(i, 4);
      i -= 3;
    }
  }

  return count;
}
