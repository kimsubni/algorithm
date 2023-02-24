// let input = require("fs").readFileSync("/dev/stdin").toString().trim();
let input = `2143`;
const length = input.length;

const arr = input.split("").map(Number);
/*
1. 남은 정렬부분에서 최솟값 또는 최댓값을 찾는다.
2. 남은 정렬부분에서 가장 앞에 있는 데이터와 선택된 데이터를 스왑한다.
3. 가장 앞에 있는 데이터의 위치를 변경해 (index++) 남은 정렬부분의 범위를 축소한다.
4. 전체 데이터 크기만큼 index가 커질때까지, 즉 남은 정렬부분이 없을 때까지 반복한다.
*/

let maxIdx;

for (let i = 0; i < length; ++i) {
  let max = -1;
  for (let j = i; j < length; ++j) {
    if (max < arr[j]) {
      max = arr[j];
      maxIdx = j;
    }
  }
  let tmp = arr[i];
  arr[i] = arr[maxIdx];
  arr[maxIdx] = tmp;
}

let answer = "";
for (let i = 0; i < length; ++i) {
  answer += arr[i];
}
console.log(answer);
