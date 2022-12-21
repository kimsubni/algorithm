function solution(s) {
  var answer = [];
  let isDup = {};
  for (let i = 0; i < s.length; ++i) {
    let letter = s[i];
    if (isDup[letter] >= 0) {
      answer.push(i - isDup[letter]);
      isDup[letter] = i;
    } else {
      isDup[letter] = i;
      answer.push(-1);
    }
  }

  return answer;
} // this is my solution

const solution2 = (s) => {
  [...s].map((char, i) => {
    const count = s.slice(0, i).lastIndexOf(char);
    return count < 0 ? count : i - count;
  });
};

const solution3 = (s) => {
  return s.split("").reduce((acc, cur, idx) => {
    const f = s.slice(0, idx).lastIndexOf(cur);

    if (!idx || f === -1) acc.push(-1);
    else acc.push(idx - f);

    return acc;
  }, []);
};

const solution4 = (s) => {
  const hash = {};
  return [...s].map((v, i) => {
    let result = hash[v] !== undefined ? i - hash[v] : -1;
    hash[v] = i;
    return result;
  });
};
