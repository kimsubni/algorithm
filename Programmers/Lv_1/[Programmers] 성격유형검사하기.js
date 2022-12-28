function solution(servey, choices) {
  var answer = "";
  var type = [
    ["R", "T"],
    ["C", "F"],
    ["J", "M"],
    ["A", "N"],
  ];
  var character = {};
  for (let i = 0; i < type.length; ++i) {
    character[type[i][0]] = 0;
    character[type[i][1]] = 0;
  }
  console.log(character);

  for (let i = 0; i < servey.length; ++i) {
    if (choices[i] >= 1 && choices[i] <= 3) {
      character[servey[i][0]] += 4 - choices[i];
    }
    if (choices[i] >= 4 && choices[i] <= 7) {
      character[servey[i][1]] += choices[i] - 4;
    }
  }
  for (let i = 0; i < type.length; ++i) {
    answer +=
      character[type[i][0]] >= character[type[i][1]] ? type[i][0] : type[i][1];
  }
  return answer;
}

console.log(solution(["AN", "CF", "MJ", "RT", "NA"], [5, 3, 2, 7, 5]));
