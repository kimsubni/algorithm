function solution(k, score) {
  var answer = [];
  var topRanking = [];
  for (let i = 0; i < score.length; ++i) {
    if (topRanking.length < k || topRanking[0] < score[i]) {
      topRanking.push(score[i]);
      for (let index = 1; index < topRanking.length; ++index) {
        let temp = topRanking[index];
        let prev = index - 1;
        while (prev >= 0 && topRanking[prev] > temp) {
          topRanking[prev + 1] = topRanking[prev];
          prev--;
        }
        topRanking[prev + 1] = temp;
      }
      if (topRanking.length > k) {
        topRanking = topRanking.slice(1, k + 1);
      }
      answer.push(topRanking[0]);
    } else {
      answer.push(topRanking[0]);
      continue;
    }
  }
  return answer;
}

console.log(solution(3, [10, 100, 20, 150, 1, 100, 200]));

function solution2(k, score) {
  let answer = [];
  let list = [];
  for (let i = 0; i < score.length; i++) {
    list.push(score[i]);
    list.sort((a, b) => b - a);
    if (list.length > k) {
      list.pop();
    }
    answer.push(list[list.length - 1]);
  }
  return answer;
}

function solution3(k, score) {
  var answer = [];
  const temple = [];
  for (let x of score) {
    temple.push(x);
    temple.sort((a, b) => b - a);
    temple.splice(k);
    answer.push([...temple].pop());
  }
  return answer;
}
