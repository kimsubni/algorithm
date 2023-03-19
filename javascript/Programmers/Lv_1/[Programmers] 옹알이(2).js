function solution(babbling) {
  var answer = 0;
  for (let i = 0; i < babbling.length; ++i) {
    let letter = babbling[i];
    const arr = ["aya", "ye", "woo", "ma"];
    for (let j = 0; j < arr.length; ++j) {
      if (letter.length === 0) {
        answer++;
        break;
      }
      if (letter.indexOf(arr[j].concat(arr[j])) >= 0) {
        break;
      }
      if (letter.indexOf(arr[j]) === 0) {
        letter = letter.slice(arr[j].length);
        j = -1;
      }
      if (j == 3 && letter.length > 0) {
        break;
      }
    }
  }
  return answer;
}
console.log(solution(["ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"]));

function solution2(babbling) {
  const regexp1 = /(aya|ye|woo|ma)\1+/;
  const regexp2 = /^(aya|ye|woo|ma)+$/;

  return babbling.reduce(
    (ans, word) => (!regexp1.test(word) && regexp2.test(word) ? ++ans : ans),
    0
  );
}

// 이 뭐 말도안되는 풀이지
