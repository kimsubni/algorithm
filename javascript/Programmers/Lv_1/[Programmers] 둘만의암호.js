function solution(s, skip, index) {
  var answer = "";
  const alphabet = [
    "a",
    "b",
    "c",
    "d",
    "e",
    "f",
    "g",
    "h",
    "i",
    "j",
    "k",
    "l",
    "m",
    "n",
    "o",
    "p",
    "q",
    "r",
    "s",
    "t",
    "u",
    "v",
    "w",
    "x",
    "y",
    "z",
  ];
  for (let i = 0; i < s.length; ++i) {
    let num = s[i].charCodeAt() - 97;
    let idx = 1;
    while (idx <= index) {
      if (num + 1 >= 26) {
        num = 0;
      } else {
        num += 1;
      }
      if (skip.indexOf(alphabet[num]) >= 0) {
        continue;
      } else {
        idx++;
      }
    }
    answer += alphabet[num];
  }
  return answer;
}
