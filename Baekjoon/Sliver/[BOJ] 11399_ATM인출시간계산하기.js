const input = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n");


const N = Number(input[0]);

/*
1. 현재 index에 있는 데이터 값을 선택한다.
2. 현재 선택한 데이터가 정렬된 데이터 범위에 삽입될 위치를 탐색한다.
3. 삽입 위치부터 index에 있는 위치까지 shift 연산을 수행한다.
4. 삽입위치에 현재 선택한 데이터를 삽입하고 index++연산을 수행한다.
5. 전체 데이터ㅏ의 크기만큼 index가 커질떄까지, 즉 선택한 데이터가 없을떄까지 반복한다.

*/

const arr = input[1].split(" ").map(Number);

for (let i = 1; i < N; ++i) {
  let tmp = arr[i];
  let prev = i - 1;
  while (prev >= 0 && arr[prev] > tmp) {
    arr[prev + 1] = arr[prev];
    prev--;
  }
  arr[prev + 1] = tmp;
}
let answer = 0;
let sum = [];
sum[0] = arr[0];
answer = sum[0];
for (let i = 1; i < N; ++i) {
  sum[i] = arr[i] + sum[i - 1];
  answer += sum[i];
}
console.log(answer);
