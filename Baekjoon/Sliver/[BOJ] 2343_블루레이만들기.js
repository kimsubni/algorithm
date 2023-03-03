// const input = require("fs")
//   .readFileSync("/dev/stdin")
//   .toString()
//   .trim()
//   .split("\n");

const input = `7 3
4 5 7 8 9 22 34`.trim().split("\n")



const [N,M] = input[0].split(" ").map(Number);

const arr = input[1].split(' ').map(Number);

let sum = [];
let answer = 10000;

sum[0] = arr[0];
// 합을 구하고
for(let i = 1; i <N; ++i){
  sum[i] = arr[i] + sum[i-1];
}
let min = Math.floor(sum[N-1]/M);
let start = 0;
let end = 0;

for(let i = 0; i < N; ++i){
  if(start < arr[i]) start = arr[i];
  end = end+ arr[i];
}

while(start <= end){
  let middle = Math.floor((start+end)/2);
  let sum = 0;
  let count = 0;
  for(let i = 0; i < N; ++i){
    if(sum+arr[i] >middle){
      count++;
      sum = 0;
    }
    sum = sum+ arr[i];
  }
  if(sum!=0){
    count++;
  }
  if(count>M){
    start = middle+1;
  }else{
    end = middle-1;
  }
}
console.log(start);