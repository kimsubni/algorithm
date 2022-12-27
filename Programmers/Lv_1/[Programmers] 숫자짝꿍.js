function solution(X, Y) {
  var answer = "";
  let frequencyCnt1 = {};
  let frequencyCnt2 = {};
  let arr = [];

  for (let val of X) {
    frequencyCnt1[val] = (frequencyCnt1[val] || 0) + 1;
  }
  for (let val of Y) {
    frequencyCnt2[val] = (frequencyCnt2[val] || 0) + 1;
  }

  for (let key in frequencyCnt1) {
    if (!(key in frequencyCnt2)) {
      continue;
    }
    for (let i = 0; i < Math.min(frequencyCnt1[key], frequencyCnt2[key]); ++i) {
      arr.push(key);
    }
  }
  if (arr.length === 0) {
    answer = "-1";
  } else if (Number(arr.join("")) === 0) {
    answer = "0";
  } else {
    answer = arr.sort((a, b) => b - a).join("");
  }
  return answer;
}
console.log(solution("5525", "1255"));

function solutionSame(X, Y) {
  var answer = "";
  const dic1 = {};
  const dic2 = {};
  for (let i = 0; i < 10; i++) {
    dic1[String(i)] = 0;
    dic2[String(i)] = 0;
  }
  for (const i of X) {
    dic1[i] += 1;
  }
  for (const i of Y) {
    dic2[i] += 1;
  }
  for (const i of Object.keys(dic1).reverse()) {
    if (!answer && i === "0")
      answer += i.repeat(Math.min(dic1["0"], dic2["0"], 1));
    else {
      answer += i.repeat(Math.min(dic1[i], dic2[i]));
    }
  }
  if (answer) return answer;
  return "-1";
} // 요코드는 나랑 똑같이풀었넹? 비슷한데 약간은 다른 풀이법.

function solution2(X, Y) {
  X = X.split("");
  Y = Y.split("");
  let answer = "";
  for (let i = 0; i < 10; i++) {
    const xCnt = X.filter((x) => Number(x) === i).length;
    const yCnt = Y.filter((y) => Number(y) === i).length;
    answer += String(i).repeat(Math.min(xCnt, yCnt));
  }
  if (!answer) return "-1";
  if (Number(answer) === 0) return "0";
  return answer
    .split("")
    .sort((a, b) => b - a)
    .join("");
}

// 좋아요를 가장 많이 받은 코드
function solutionBestGood(X, Y) {
  const commonNumbers = [...new Set(X.split(""))]
    .filter((number) => {
      return Y.includes(number);
    })
    .sort((a, b) => b - a);

  if (!commonNumbers.length) return "-1";

  if (!Number(commonNumbers[0])) return "0";

  return commonNumbers
    .map((number) => {
      const Xcount = X.split("").reduce((count, Xnumber) => {
        if (Xnumber === number) return (count += 1);

        return count;
      }, 0);

      const Ycount = Y.split("").reduce((count, Ynumber) => {
        if (Ynumber === number) return (count += 1);

        return count;
      }, 0);

      return Xcount <= Ycount ? number.repeat(Xcount) : number.repeat(Ycount);
    })
    .join("");
}
