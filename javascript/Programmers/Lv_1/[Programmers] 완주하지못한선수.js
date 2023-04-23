function solution(participant, completion) {
  const map = new Map();
  participant.forEach((value) => {
    if (map.has(value)) {
      map.set(value, map.get(value) + 1);
    } else {
      map.set(value, 1);
    }
  });
  let answer = "";
  completion.forEach((value) => {
    if (map.has(value)) {
      map.set(value, map.get(value) - 1);
    }
  });

  map.forEach((value, key) => {
    if (value > 0) answer = key;
  });
  return answer;
}

// 아니면

function solution2(participant, completion) {
  participant.sort();
  completion.sort();
  for (var i = 0; i < participant.length; i++) {
    if (participant[i] !== completion[i]) {
      return participant[i];
    }
  }
}
