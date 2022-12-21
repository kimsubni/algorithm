function solution(s) {
  var answer = 0;
  var isCount = 0;
  for (let i = 0; i < s.length; ++i) {
    if (isCount === 0) {
      answer++;
      letter = s[i];
    }
    if (letter === s[i]) {
      isCount++;
    } else {
      isCount--;
    }
  }
  return answer;
}

console.log(solution("abracadabra"));

function solution2(s, count = 0) {
  if (!s) return count;
  let [first, ...rest] = s.split("");
  let countSame = 1;
  let countInSame = 0;
  let i = 0;
  for (; i < rest.length; i++) {
    if (rest[i] === first) countSame++;
    else countInSame++;
    if (countSame === countInSame) break;
  }
  return solution(rest.slice(i + 1).join(""), count + 1);
}

function solution3(s) {
  let tar = "";
  let cnt = (ans = 0);
  for (let c of s) {
    if (!tar) tar = c;
    cnt += tar === c ? 1 : -1;
    if (!cnt) (tar = ""), ans++;
  }
  return !!cnt + ans;
}
